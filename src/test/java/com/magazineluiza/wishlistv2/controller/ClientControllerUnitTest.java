package com.magazineluiza.wishlistv2.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.magazineluiza.wishlistv2.controllers.ClientController;
import com.magazineluiza.wishlistv2.domain.entity.Client;
import com.magazineluiza.wishlistv2.mother.ClientMother;
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
  void givenValidClientWhenCreateThenReturnSucess() throws Exception {
    Client client = ClientMother.createClient();

    given(clientService.create(any())).willReturn(client);

    Gson gson = new Gson();
    String jsonBody = gson.toJson(client);

    mvc.perform(post(CLIENT_ENDPOINT)
        .content(jsonBody)
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
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
