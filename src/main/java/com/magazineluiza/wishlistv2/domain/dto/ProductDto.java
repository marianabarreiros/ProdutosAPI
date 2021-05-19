package com.magazineluiza.wishlistv2.domain.dto;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;

public class ProductDto {

  @NotNull
  private String nome;
  @NotNull
  private String categoria;
  @NotNull
  private Double preco;
  @NotNull
  private String descricao;
  @NotNull
  private String imagem;

  private Set<Client> clients = new HashSet<>();

  public ProductDto(@NotNull String nome,
      @NotNull String categoria, @NotNull Double preco,
      @NotNull String descricao, @NotNull String imagem,
      Set<Client> clients) {
    this.nome = nome;
    this.categoria = categoria;
    this.preco = preco;
    this.descricao = descricao;
    this.imagem = imagem;
    this.clients = clients;
  }

  public ProductDto() {
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public Set<Client> getClients() {
    return clients;
  }

  public void setClients(Set<Client> clients) {
    this.clients = clients;
  }
}
