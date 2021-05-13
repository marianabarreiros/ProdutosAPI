package com.magazineluiza.wishlistv2.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

  private String nome;
  private Double valor;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

}
