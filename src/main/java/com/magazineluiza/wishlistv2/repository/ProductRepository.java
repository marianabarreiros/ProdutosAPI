package com.magazineluiza.wishlistv2.repository;

import com.magazineluiza.wishlistv2.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
