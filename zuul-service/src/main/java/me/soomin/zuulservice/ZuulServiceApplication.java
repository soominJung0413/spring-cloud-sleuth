package me.soomin.zuulservice;

import me.soomin.zuulservice.routelocator.CustomRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServiceApplication {

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private ZuulProperties zuulProperties;

    @Bean
    public CustomRouteLocator customRouteLocator(){
        return new CustomRouteLocator(serverProperties.getServlet().getContextPath(),zuulProperties);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApplication.class, args);
    }

}
