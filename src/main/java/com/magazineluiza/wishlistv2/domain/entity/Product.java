package com.magazineluiza.wishlistv2.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String categoria;
  private Double preco;
  private String descricao;
  private String imagem;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
  private Set<Client> clientes = new HashSet<>();

  public Product() {

  }

  public Product(Long id, String nome, String categoria, Double preco, String descricao,
      String imagem) {
    this.id = id;
    this.nome = nome;
    this.categoria = categoria;
    this.preco = preco;
    this.descricao = descricao;
    this.imagem = imagem;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @JsonIgnore
  public Set<Client> getClientes() {
    return clientes;
  }

  @JsonProperty
  public void setClientes(Set<Client> clients) {
    this.clientes = clients;
  }
}