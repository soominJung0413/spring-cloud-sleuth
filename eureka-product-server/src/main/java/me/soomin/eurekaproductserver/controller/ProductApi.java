package me.soomin.eurekaproductserver.controller;

import me.soomin.eurekaproductserver.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface ProductApi {

    @PostMapping("/api/product/register")
    ResponseEntity<Object> processRegister(@RequestBody Map<String,String> map);

    @GetMapping("/api/product/find/{id}")
    ResponseEntity<Object> findProductById(@PathVariable("id") Long id);
}
