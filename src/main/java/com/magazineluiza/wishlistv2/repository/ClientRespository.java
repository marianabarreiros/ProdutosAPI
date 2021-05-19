package com.magazineluiza.wishlistv2.repository;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRespository extends JpaRepository<Client, Long> {

}
