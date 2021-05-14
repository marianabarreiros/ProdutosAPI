package com.magazineluiza.wishlistv2.wishlist;

import com.magazineluiza.wishlistv2.cliente.Cliente;
import com.magazineluiza.wishlistv2.produto.Produto;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "wishlist")
public class Wishlist {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(mappedBy = "wishlist")
  private Cliente cliente;

  @ManyToMany(mappedBy = "wishlists")
  private List<Produto> produtoList;
}
