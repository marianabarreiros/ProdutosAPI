package com.magazineluiza.wishlistv2.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

  private String nome;
  private Double valor;
  private long id;

  public ProdutoDto(Produto produto) {
    this.nome = produto.getNome();
    this.valor = produto.getValor();
    this.id = produto.getId();
  }

  public ProdutoDto(){}

  public List<ProdutoDto> converterList(List<Produto> produtos) {
//    List<ProdutoDto> produtoDtos = new ArrayList<>();
//    for(int i = 0; i < produtos.size(); i++ ){
//      produtoDtos.add(new ProdutoDto(produtos.get(i)));
//    }
//    return produtoDtos;
    return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
  }

  public ProdutoDto converteEntidadeProdutoParaProdutoDto(Produto produto) {
    return new ProdutoDto(produto);
  }

}
