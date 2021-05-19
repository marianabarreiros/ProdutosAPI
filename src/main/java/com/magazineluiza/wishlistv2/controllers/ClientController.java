package com.magazineluiza.wishlistv2.controllers;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import com.magazineluiza.wishlistv2.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Client create(@RequestBody Client client) {
    return clientService.create(client);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable(value = "id") long id) {
    Client client = clientService.getClientById(id);
    if (client != null) {
      return new ResponseEntity<>(client, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Object> deleteClientById(@PathVariable(value = "id") long id) {
    try {
      Boolean deletedClient = clientService.deleteClientById(id);
      if (deletedClient) {
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>("Erro ao deletar cliente" + e, HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Client> updateClientById(@PathVariable(value = "id") long id,
      @RequestBody Client cliente) {
    Client client = clientService.updateClientById(id, cliente);
    if (client != null) {
      return new ResponseEntity<>(client, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}