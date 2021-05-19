package com.magazineluiza.wishlistv2.domain.service;

import com.magazineluiza.wishlistv2.domain.entity.Cliente;
import com.magazineluiza.wishlistv2.domain.repository.ClienteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteRepository _clienteRepository;

    @Override
    public Cliente GetById(Long id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }

    @Override
    public Cliente Create(Cliente cliente) {
        return _clienteRepository.save(cliente);
    }

    @Override
    public Boolean Delete(Long id) {
        Cliente cliente = GetById(id);
        if (cliente != null) {
             cliente.getProdutos().removeAll(cliente.getProdutos());
            _clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Cliente Update(Long id, Cliente _cliente) {
        Cliente cliente = GetById(id);
        if (cliente != null) {
            cliente.setNome(_cliente.getNome());
            cliente.setSobrenome(_cliente.getSobrenome());
            cliente.setCpf(_cliente.getCpf());
            return Create(cliente);
        }
        return null;
    }

    @Override
    public Cliente GetByCpf(String cpf) {
        Optional<Cliente> cliente = _clienteRepository.findByCpf(cpf);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }
}