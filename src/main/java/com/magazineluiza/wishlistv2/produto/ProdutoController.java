package com.magazineluiza.wishlistv2.produto;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getProdutos(){
        return produtoService.getProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProduto(@PathVariable("id") long id){
        return produtoService.getProduto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduto(@RequestBody Produto produto) {
        produtoService.adcionarProduto(produto);
    }
}
