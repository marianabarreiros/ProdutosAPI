package com.magazineluiza.wishlistv2.controller;

import static com.magazineluiza.wishlistv2.mother.ClientMother.createClient;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.magazineluiza.wishlistv2.controllers.ClientController;
import com.magazineluiza.wishlistv2.domain.entity.Client;
import com.magazineluiza.wishlistv2.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
    ClientController.class,
    ClientService.class
})
public class ClientControllerUnitTest {

  private static final String CLIENT_ENDPOINT = "/cliente";

  @Autowired
  private MockMvc mvc;

  @MockBean
  private ClientService clientService;

  @Test
  void givenValidClientWhenCreateThenReturnEntityClient() throws Exception {

    Client client = createClient();

    given(clientService.create(any())).willReturn(client);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(client);

    mvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(print())
        .andExpect(jsonPath("$.id").value(client.getId()))
        .andExpect(jsonPath("$.nome").value(client.getNome()))
        .andExpect(jsonPath("$.sobrenome").value(client.getSobrenome()))
        .andExpect(jsonPath("$.cpf").value(client.getCpf()));

  }


  @Test
  void givenValidIdWhenGetClientByIdThenReturnOk() throws Exception {

    Client client = createClient();

    given(clientService.getClientById(1L)).willReturn(client);

    mvc.perform(get(CLIENT_ENDPOINT + "/" + client.getId()))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(jsonPath("$.id").value(client.getId()))
        .andExpect(jsonPath("$.nome").value(client.getNome()))
        .andExpect(jsonPath("$.sobrenome").value(client.getSobrenome()))
        .andExpect(jsonPath("$.cpf").value(client.getCpf()));

    verify(clientService, times(1)).getClientById(1L);
  }

  @Test
  void givenINvalidClientWhenCreateThenReturnBadRequest() throws Exception {
    Gson gson = new Gson();
    String jsonBody = gson.toJson(null);

    mvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());

  }
}
