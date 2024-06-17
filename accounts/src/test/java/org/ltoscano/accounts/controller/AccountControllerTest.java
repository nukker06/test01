package org.ltoscano.accounts.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
    @DisplayName("Get all Accounts")
    void when_call_get_all_products_then_return_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cuentas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Master")))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
    }
}
