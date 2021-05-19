package com.magazineluiza.wishlistv2.domain.repository;


import com.magazineluiza.wishlistv2.domain.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}

