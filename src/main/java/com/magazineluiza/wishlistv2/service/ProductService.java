package com.magazineluiza.wishlistv2.service;

import com.magazineluiza.wishlistv2.domain.entity.Product;
import com.magazineluiza.wishlistv2.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Iterable<Product> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    Optional<Product> produto = productRepository.findById(id);
    if (produto.isPresent()) {
      return produto.get();
    }
    return null;
  }

  @Override
  public Product create(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Boolean deleteProductById(Long id) {
    Product product = getProductById(id);
    if (product != null) {
      productRepository.delete(product);
      return true;
    }
    return false;
  }

  @Override
  public Product updateProductById(Long id, Product _product) {
    Product product = getProductById(id);
    if (product != null) {
      product.setNome(_product.getNome());
      product.setCategoria(_product.getCategoria());
      product.setPreco(_product.getPreco());
      product.setDescricao(_product.getDescricao());
      return create(product);
    }
    return null;
  }
}