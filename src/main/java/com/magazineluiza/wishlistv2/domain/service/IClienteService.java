package com.magazineluiza.wishlistv2.domain.service;


import com.magazineluiza.wishlistv2.domain.entity.Cliente;

public interface IClienteService {
    Cliente GetById(Long id);
    Cliente GetByCpf(String cpf);
    Cliente Create (Cliente cliente);
    Cliente Update (Long id, Cliente cliente);
    Boolean Delete (Long id);
}