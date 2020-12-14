package me.soomin.eurekaproductserver.service.feign;

import me.soomin.eurekaproductserver.service.feign.fallback.AccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "EUREKA-CLIENT",fallbackFactory = AccountServiceFallback.class)
public interface AccountServiceClient {
    @PostMapping("/api/client/register")
    ResponseEntity<Object> processRegister(Map<String,String> map);

    @GetMapping("/api/client/find/{id}")
    ResponseEntity<Object> processFindById(@PathVariable("id") Long id);

    @PostMapping("/api/client/register/product")
    ResponseEntity<Object> processRegisterProductId(@RequestBody Map<String,String> map);
}
