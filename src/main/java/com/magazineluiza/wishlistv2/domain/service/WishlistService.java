package com.magazineluiza.wishlistv2.domain.service;

import com.magazineluiza.wishlistv2.domain.entity.Cliente;
import com.magazineluiza.wishlistv2.domain.entity.Produto;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService implements IWishlistService {
  @Autowired
  private ClienteService _clienteService;

  @Autowired
  private ProdutoService _produtoService;

  @Override
  public Object Create(Long idCliente, long idProduto) throws Exception {
//    if (idProdutos.size() > 20) {
//      throw new Exception("não pode adicionar mais de 20 produtos!");
//    }

    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      Produto produto = _produtoService.GetById(idProduto);
      cliente.adicionarProduto(produto);
      return _clienteService.Create(cliente);
    }
    return null;
  }

  @Override
  public Set<Produto> GetProdutosByIdCliente(Long idCliente) {
    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      return cliente.getProdutos();
    }
    return null;
  }

  @Override
  public Produto GetProdutoByIdProduto(Long idCliente, Long idProdutos) {
    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      Set<Produto> produtos = cliente.getProdutos();
      return produtos.stream().filter(item -> item.getId().equals(idProdutos)).findFirst().orElse(null);
    }
    return null;
  }

}
