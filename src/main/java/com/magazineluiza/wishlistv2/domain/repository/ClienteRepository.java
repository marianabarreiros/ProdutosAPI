package com.magazineluiza.wishlistv2.domain.repository;


import com.magazineluiza.wishlistv2.domain.entity.Cliente;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
    public void deleteById(Long id);
}
