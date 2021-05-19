package com.magazineluiza.wishlistv2.domain.service;


import com.magazineluiza.wishlistv2.domain.entity.Produto;
import java.util.Set;

public interface IWishlistService {
    Object Create (Long idCliente, long idProdutos) throws Exception;
    Set<Produto> GetProdutosByIdCliente (Long idCliente);
    Produto GetProdutoByIdProduto (Long idCliente, Long idProdutos);
}