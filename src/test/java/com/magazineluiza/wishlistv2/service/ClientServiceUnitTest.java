package com.magazineluiza.wishlistv2.service;

import static com.magazineluiza.wishlistv2.mother.ClientMother.createClient;
import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import com.magazineluiza.wishlistv2.repository.ClientRespository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientServiceUnitTest {

  @InjectMocks
  private ClientService clientService;

  @Mock
  private ClientRespository clientRespository;

  @Test
  void givenAValidClientWhenCreateThenReturnEntityClient() {
    Client client = createClient();

    given(clientRespository.save(client)).willReturn(client);

    Client client1 = clientService.create(client);

    then(client1.getCpf()).isEqualTo(client.getCpf());
    then(client1.getId()).isEqualTo(client.getId());
    then(client1.getProdutos()).isEqualTo(client.getProdutos());
    then(client1.getNome()).isEqualTo(client.getNome());
    then(client1.getSobrenome()).isEqualTo(client.getSobrenome());

    verify(clientService, times(1)).create(client);
  }

  @Test
  void givenANullValueWhenGetCleintByIdThenReturnEmpty() {

    given(clientRespository.findById(1L)).willReturn(Optional.of(createClient()));

    Client client = clientService.getClientById(1L);

    then(clientRespository.findById(2L)).isEmpty();
  }
  

}
