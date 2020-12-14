package me.soomin.eurekaproductserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "eureka.client.enabled=false")
class EurekaProductServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
