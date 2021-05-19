package com.magazineluiza.wishlistv2.controllers;

import com.magazineluiza.wishlistv2.domain.entity.Cliente;
import com.magazineluiza.wishlistv2.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClienteController
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService _clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") long id) {
        Cliente cliente = _clienteService.GetById(id);
        if (cliente != null)
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> GetByCpf(@PathVariable(value = "cpf") String cpf) {
        Cliente cliente = _clienteService.GetByCpf(cpf);
        if (cliente != null)
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cliente> Create(@RequestBody Cliente cliente) {
        return new ResponseEntity<Cliente>(_clienteService.Create(cliente), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        try {
            Boolean deletedClient = _clienteService.Delete(id);
            if (deletedClient)
                return new ResponseEntity<Object>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar cliente" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> Update(@PathVariable(value = "id") long id, @RequestBody Cliente cliente) {
        Cliente client = _clienteService.Update(id, cliente);
        if (client != null)
            return new ResponseEntity<Cliente>(client, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}