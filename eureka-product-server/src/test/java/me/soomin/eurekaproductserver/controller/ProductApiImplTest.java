package me.soomin.eurekaproductserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.soomin.eurekaproductserver.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "eureka.client.enabled=false")
@AutoConfigureMockMvc
class ProductApiImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        Product product = new Product();
        product.setProductName("New Pencil");
        product.setProductDetail("Black Color");
        product.setAccountId(1L);

        mockMvc.perform(post("/api/product/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productDetail",is("Black Color")));

        System.out.println("=========================================================================================");

        mockMvc.perform(get("/api/product/find/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}