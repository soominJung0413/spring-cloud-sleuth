package me.soomin.zuulservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "eureka.client.enabled=false")
class ZuulServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
