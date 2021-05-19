package com.magazineluiza.wishlistv2.service;


import com.magazineluiza.wishlistv2.domain.entity.Product;
import java.util.Set;

public interface IWishlistService {

  Object create(Long idCliente, long idProdutos) throws Exception;

  Set<Product> getProductByClientId(Long idCliente);

  Product getProductByProductId(Long idCliente, Long idProdutos);
}