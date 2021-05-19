package com.magazineluiza.wishlistv2.domain.service;


import com.magazineluiza.wishlistv2.domain.entity.Produto;

public interface IProdutoService {

  Iterable<Produto> GetAll();

  Produto GetById(Long id);

  Produto Create(Produto produto);

  Produto Update(Long id, Produto produto);

  Boolean Delete(Long id);
}