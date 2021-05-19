package com.magazineluiza.wishlistv2.controllers;

import com.magazineluiza.wishlistv2.domain.entity.Product;
import com.magazineluiza.wishlistv2.service.WishlistService;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

  private final WishlistService wishlistService;

  public WishlistController(
      WishlistService wishlistService) {
    this.wishlistService = wishlistService;
  }

  @PostMapping(value = "/{idCliente}/{idProduto}")
  public ResponseEntity<Object> Create(@PathVariable(value = "idCliente") long idCliente,
      @PathVariable(value = "idProduto") long idProduto) {
    try {
      return new ResponseEntity<>(wishlistService.create(idCliente, idProduto),
          HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao adicionar produtos na wishList" + e,
          HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/cliente/{idCliente}")
  public ResponseEntity<Set<Product>> GetProductsByClientId(
      @PathVariable(value = "idCliente") long idCliente) {
    Set<Product> products = wishlistService.getProductByClientId(idCliente);
    if (products != null) {
      return new ResponseEntity<>(products, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/cliente/{idCliente}/produto/{idProduto}")
  public ResponseEntity<Product> GetById(@PathVariable(value = "idCliente") long idCliente,
      @PathVariable(value = "idProduto") long idProduto) {
    Product product = wishlistService.getProductByProductId(idCliente, idProduto);
    if (product != null) {
      return new ResponseEntity<>(product, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
