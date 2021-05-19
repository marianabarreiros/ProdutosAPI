package com.magazineluiza.wishlistv2.controllers;

import com.magazineluiza.wishlistv2.domain.entity.Produto;
import com.magazineluiza.wishlistv2.domain.service.WishlistService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * WishListController
 */
@RestController
@RequestMapping("/wishList")
public class WishListController {
    @Autowired
    private WishlistService _wishlistService;

    @RequestMapping(value = "/{idCliente}/{idProduto}", method = RequestMethod.POST)
    public ResponseEntity<Object> Create(@PathVariable(value = "idCliente") long idCliente,
                                         @PathVariable(value = "idProduto") long idProduto) {
        try {
            return new ResponseEntity<Object>(_wishlistService.Create(idCliente, idProduto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao adicionar produtos na wishList" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity<Set<Produto>> GetProdutosByIdCliente(@PathVariable(value = "idCliente") long idCliente) {
        Set<Produto> produtos = _wishlistService.GetProdutosByIdCliente(idCliente);
        if (produtos != null)
            return new ResponseEntity<Set<Produto>>(produtos, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cliente/{idCliente}/produto/{idProduto}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "idCliente") long idCliente, @PathVariable(value = "idProduto") long idProduto) {
        Produto produto = _wishlistService.GetProdutoByIdProduto(idCliente, idProduto);
        if (produto != null)
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
