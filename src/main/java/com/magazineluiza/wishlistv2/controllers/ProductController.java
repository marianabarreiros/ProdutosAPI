package com.magazineluiza.wishlistv2.controllers;

import com.magazineluiza.wishlistv2.domain.entity.Product;
import com.magazineluiza.wishlistv2.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProductController {

  private final ProductService produtoService;

  public ProductController(ProductService produtoService) {
    this.produtoService = produtoService;
  }

  @GetMapping
  public ResponseEntity<Iterable<Product>> getProducts() {
    return new ResponseEntity<>(produtoService.getProducts(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable(value = "id") long id) {
    Product product = produtoService.getProductById(id);
    if (product != null) {
      return new ResponseEntity<>(product, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product product) {
    return new ResponseEntity<>(produtoService.create(product), HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> delete(@PathVariable(value = "id") long id) {
    try {
      Boolean deletedProduct = produtoService.deleteProductById(id);
      if (deletedProduct) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao deletar produto, existe cliente vinculado a ele" + e,
          HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Product> update(@PathVariable(value = "id") long id,
      @RequestBody Product produto) {
    Product product = produtoService.updateProductById(id, produto);
    if (product != null) {
      return new ResponseEntity<>(product, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}