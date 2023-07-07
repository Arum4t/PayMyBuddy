package com.paymybuddy.webapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    @WithMockUser(username = "testeur@test.com", password = "testeur", roles = "user")
    public void addTransactionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/pay")
                        .param("contactEmail", "testeurContact@test.com")
                        .param("amount", "10")
                        .param("description", "fastFood"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/transfers/"))
                .andExpect(MockMvcResultMatchers.status().isFound());

    }
}