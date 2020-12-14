package me.soomin.eurekaproductserver.service.feign.fallback;

import feign.hystrix.FallbackFactory;
import me.soomin.eurekaproductserver.service.feign.AccountServiceClient;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class AccountServiceFallback implements FallbackFactory<AccountServiceClient> {
    @Override
    public AccountServiceClient create(Throwable cause) {
        return new AccountServiceClient() {
            @Override
            public ResponseEntity<Object> processRegister(Map<String, String> map) {
                return null;
            }

            @Override
            public ResponseEntity<Object> processFindById(Long id) {
                return null;
            }

            @Override
            public ResponseEntity<Object> processRegisterProductId(Map<String, String> map) {
                return null;
            }
        };
    }
}
