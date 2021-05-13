package com.magazineluiza.wishlistv2.produto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProduto(long id) {
        return produtoRepository.findById(id);
    }

    public void adcionarProduto(Produto produto) {
        produtoRepository.save(produto);
    }
}
