package com.magazineluiza.wishlistv2.mother;

import com.magazineluiza.wishlistv2.domain.entity.Client;
import java.util.Collections;

public class ClientMother {

  public static Client createClient(){
    return new Client(1L, "Mariana", "Barreiros", 12345678L, Collections.EMPTY_SET);
  }

}
