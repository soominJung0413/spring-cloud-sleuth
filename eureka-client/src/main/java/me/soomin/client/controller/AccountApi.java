package me.soomin.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface AccountApi {

    @PostMapping("/api/client/register")
    ResponseEntity<Object> processRegister(Map<String,String> map);

    @GetMapping("/api/client/find/{id}")
    ResponseEntity<Object> processFindById(@PathVariable("id") Long id);

    @PostMapping("/api/client/register/product")
    ResponseEntity<Object> processRegisterProductId(@RequestBody Map<String,String> map);
}
