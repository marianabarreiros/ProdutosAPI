package com.magazineluiza.wishlistv2.domain.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String sobrenome;
  @Column(unique = true)
  private Long cpf;
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "wishlist",
      joinColumns = @JoinColumn(name = "id_cliente"),
      inverseJoinColumns = @JoinColumn(name = "id_produto"))

  private Set<Product> produtos = new HashSet<>();

  public Client() {

  }

  public Client(Long id, String nome, String sobrenome, Long cpf, Set<Product> produtos) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    this.produtos = produtos;
  }

  public Set<Product> getProdutos() {
    return produtos;
  }

  public void setProdutos(Set<Product> products) {
    this.produtos = products;
  }

  public void adicionarProduto(Product product) {
    this.getProdutos().add(product);
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

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public Long getCpf() {
    return cpf;
  }

  public void setCpf(Long cpf) {
    this.cpf = cpf;
  }
}