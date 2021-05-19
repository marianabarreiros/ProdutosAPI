package com.magazineluiza.wishlistv2.service;


import com.magazineluiza.wishlistv2.domain.entity.Product;

public interface IProductService {

  Iterable<Product> getProducts();

  Product getProductById(Long id);

  Product create(Product product);

  Product updateProductById(Long id, Product product);

  Boolean deleteProductById(Long id);
}