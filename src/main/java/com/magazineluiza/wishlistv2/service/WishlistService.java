package com.magazineluiza.wishlistv2.service;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import com.magazineluiza.wishlistv2.domain.entity.Product;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService implements IWishlistService {

  @Autowired
  private ClientService clientService;

  @Autowired
  private ProductService productService;

  @Override
  public Object create(Long idCliente, long idProduto) throws Exception {
//    if (idProdutos.size() > 20) {
//      throw new Exception("não pode adicionar mais de 20 produtos!");
//    }

    Client client = clientService.getClientById(idCliente);
    if (client != null) {
      Product product = productService.getProductById(idProduto);
      client.adicionarProduto(product);
      return clientService.create(client);
    }
    return null;
  }

  @Override
  public Set<Product> getProductByClientId(Long idCliente) {
    Client client = clientService.getClientById(idCliente);
    if (client != null) {
      return client.getProdutos();
    }
    return null;
  }

  @Override
  public Product getProductByProductId(Long idCliente, Long idProdutos) {
    Client client = clientService.getClientById(idCliente);
    if (client != null) {
      Set<Product> products = client.getProdutos();
      return products.stream().filter(item -> item.getId().equals(idProdutos)).findFirst()
          .orElse(null);
    }
    return null;
  }

}
