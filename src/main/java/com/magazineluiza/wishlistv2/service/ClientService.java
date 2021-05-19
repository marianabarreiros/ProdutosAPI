package com.magazineluiza.wishlistv2.service;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import com.magazineluiza.wishlistv2.repository.ClientRespository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

  private final ClientRespository clientRespository;

  public ClientService(
      ClientRespository clientRespository) {
    this.clientRespository = clientRespository;
  }

  @Override
  public Client getClientById(Long id) {
    Optional<Client> cliente = clientRespository.findById(id);
    if (cliente.isPresent()) {
      return cliente.get();
    } else {
      return null;
    }
  }

  @Override
  public Client create(Client client) {
    return clientRespository.save(client);
  }

  @Override
  public Boolean deleteClientById(Long id) {
    Client client = getClientById(id);
    if (client != null) {
      client.getProdutos().removeAll(client.getProdutos());
      clientRespository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public Client updateClientById(Long id, Client _client) {
    Client client = getClientById(id);
    if (client != null) {
      client.setNome(_client.getNome());
      client.setSobrenome(_client.getSobrenome());
      client.setCpf(_client.getCpf());
      return create(client);
    }
    return null;
  }
}