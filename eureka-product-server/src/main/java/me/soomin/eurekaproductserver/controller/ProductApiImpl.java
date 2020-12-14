package me.soomin.eurekaproductserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.soomin.eurekaproductserver.domain.Product;
import me.soomin.eurekaproductserver.service.ProductService;
import me.soomin.eurekaproductserver.service.feign.AccountServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductApiImpl implements ProductApi {
    @NonNull
    private ProductService productService;

    @Autowired
    private AccountServiceClient accountServiceClient;

    @Override
    @Transactional
    public ResponseEntity<Object> processRegister(Map<String, String> map) {
        log.warn("Parameter Map >");
        map.entrySet().forEach(stringStringEntry -> log.warn(stringStringEntry.toString()));
        Product product = new ObjectMapper().convertValue(map, Product.class);

        Product register = productService.register(product);

        Map convert = new ObjectMapper().convertValue(register, Map.class);
        Map<String,String> argsMap = new HashMap<>();
        convert.forEach((o, o2) -> argsMap.put(String.valueOf(o),String.valueOf(o2)));

        ResponseEntity<Object> responseEntity = accountServiceClient.processRegisterProductId(argsMap);



        return responseEntity.getStatusCode() == HttpStatus.OK? ResponseEntity.ok(register): ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Object> findProductById(Long id) {
        log.warn("Parameter : "+id);
        Product foundProduct = productService.findById(id);

        return ResponseEntity.ok(foundProduct);
    }
}
