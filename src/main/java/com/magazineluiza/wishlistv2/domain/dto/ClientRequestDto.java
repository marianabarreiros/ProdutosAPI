//package com.magazineluiza.wishlistv2.domain.dto;
//
//import com.magazineluiza.wishlistv2.domain.entity.Product;
//import java.util.HashSet;
//import java.util.Set;
//import javax.validation.constraints.NotNull;
//
//public class ClientRequestDto {
//
//  @NotNull
//  private String nome;
//  @NotNull
//  private String sobrenome;
//  @NotNull
//  private String cpf;
//
//  private Set<Product> products = new HashSet<>();
//
//  public ClientRequestDto(String nome, String sobrenome, String cpf,
//      Set<Product> products) {
//    this.nome = nome;
//    this.sobrenome = sobrenome;
//    this.cpf = cpf;
//    this.products = products;
//  }
//
//  public ClientRequestDto() {
//  }
//
//  public String getNome() {
//    return nome;
//  }
//
//  public void setNome(String nome) {
//    this.nome = nome;
//  }
//
//  public String getSobrenome() {
//    return sobrenome;
//  }
//
//  public void setSobrenome(String sobrenome) {
//    this.sobrenome = sobrenome;
//  }
//
//  public String getCpf() {
//    return cpf;
//  }
//
//  public void setCpf(String cpf) {
//    this.cpf = cpf;
//  }
//
//  public Set<Product> getProdutos() {
//    return products;
//  }
//
//  public void setProdutos(Set<Product> products) {
//    this.products = products;
//  }
//}
