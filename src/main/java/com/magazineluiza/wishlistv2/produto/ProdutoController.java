package com.magazineluiza.wishlistv2.produto;


import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {

  private ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @GetMapping
  public List<ProdutoDto> getProdutos() {
    return produtoService.getProdutos();
  }

  @GetMapping("/{id}")
  public ProdutoDto getProduto(@PathVariable("id") long id) {
    return produtoService.getProduto(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Produto> addProduto(@RequestBody Produto produto) {

    produtoService.adcionarProduto(produto);
    return ResponseEntity
        .created(URI.create("/produtos/" +
            produto.getId()))
        .build();
  }

  @DeleteMapping("/{id}")
  public void deleteProduto(@PathVariable("id") long id) {
    produtoService.deleteProduto(id);
  }
}
