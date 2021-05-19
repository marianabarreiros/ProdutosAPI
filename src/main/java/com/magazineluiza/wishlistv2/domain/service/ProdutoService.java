package com.magazineluiza.wishlistv2.domain.service;

import com.magazineluiza.wishlistv2.domain.entity.Produto;
import com.magazineluiza.wishlistv2.domain.repository.ProdutoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements IProdutoService {
    @Autowired
    private ProdutoRepository _produtoRepository;

    @Override
    public Iterable<Produto> GetAll() {
        return _produtoRepository.findAll();
    }

    @Override
    public Produto GetById(Long id) {
        Optional<Produto> produto = _produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }
        return null;
    }

    @Override
    public Produto Create(Produto produto) {
        return _produtoRepository.save(produto);
    }

    @Override
    public Boolean Delete(Long id) {
        Produto produto = GetById(id);
        if (produto != null) {
            _produtoRepository.delete(produto);
            return true;
        }
        return false;
    }

    @Override
    public Produto Update(Long id, Produto _produto) {
        Produto produto = GetById(id);
        if (produto != null) {
            produto.setNome(_produto.getNome());
            produto.setCategoria(_produto.getCategoria());
            produto.setPreco(_produto.getPreco());
            produto.setDescricao(_produto.getDescricao());
            return Create(produto);
        }
        return null;
    }
}