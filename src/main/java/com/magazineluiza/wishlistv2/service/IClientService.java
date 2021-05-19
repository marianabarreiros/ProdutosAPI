package com.magazineluiza.wishlistv2.service;

import com.magazineluiza.wishlistv2.domain.entity.Client;

public interface IClientService {

  Client getClientById(Long id);

  Client create(Client client);

  Client updateClientById(Long id, Client client);

  Boolean deleteClientById(Long id);

}
