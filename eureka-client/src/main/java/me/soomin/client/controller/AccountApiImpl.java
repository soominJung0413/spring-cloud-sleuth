package me.soomin.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.soomin.client.domain.Account;
import me.soomin.client.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountApiImpl implements AccountApi{
    @NonNull
    private AccountService accountService;

    @Override
    public ResponseEntity<Object> processRegister(@RequestBody Map<String, String> map) {
        Account account = new ObjectMapper().convertValue(map,Account.class);
        Account register = accountService.register(account);
        return ResponseEntity.ok(register);
    }

    @Override
    public ResponseEntity<Object> processFindById(Long id) {
        Account foundAccount = accountService.findById(id);

        return ResponseEntity.ok(foundAccount);
    }

    @Override
    public ResponseEntity<Object> processRegisterProductId(Map<String, String> map) {
        System.out.println("======================================check=========================");
        map.entrySet().forEach(System.out::println);
        Account account = accountService.registerProductId(map);
        log.warn(account.toString() + " / "+account.getProductId());
        return ResponseEntity.ok().build();
    }
}
