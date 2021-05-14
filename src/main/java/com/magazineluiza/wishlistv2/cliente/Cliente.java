package com.magazineluiza.wishlistv2.cliente;

import com.magazineluiza.wishlistv2.wishlist.Wishlist;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String endereco;

  private String email;

  private String cpf;

  @OneToOne
  @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
  private Wishlist wishlist;
}
