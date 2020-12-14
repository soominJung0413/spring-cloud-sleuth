package me.soomin.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.soomin.client.domain.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(properties = "eureka.client.enabled=false")
@AutoConfigureMockMvc
class AccountApiImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        Account account = new Account();
        account.setEmail("doli0413@daum.net");
        account.setUsername("JungSooMin");

        mockMvc.perform(post("/api/client/register")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(account)))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/client/find/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",is("JungSooMin")));
    }
}