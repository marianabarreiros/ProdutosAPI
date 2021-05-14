package com.magazineluiza.wishlistv2.produto;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final ProdutoRepository produtoRepository;
  private ProdutoDto produtoDto = new ProdutoDto();

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public List<ProdutoDto> getProdutos() {
    List<Produto> produtos = produtoRepository.findAll();
    return produtoDto.converterList(produtos);
  }

  public ProdutoDto getProduto(long id) {
    Optional<Produto> produto = produtoRepository.findById(id);
    return produtoDto.converteEntidadeProdutoParaProdutoDto(produto.get());
  }

  public void adcionarProduto(Produto produto) {
    produtoRepository.save(produto);
  }

  public void deleteProduto(long id) {
    Optional<Produto> produto = produtoRepository.findById(id);
    produtoRepository.delete(produto.get());
  }
}
