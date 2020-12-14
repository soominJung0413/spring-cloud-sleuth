package me.soomin.zuulservice.routelocator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@Slf4j
public class CustomRouteLocator extends SimpleRouteLocator {
    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
    }

    @Override
    protected ZuulProperties.ZuulRoute getZuulRoute(String adjustedPath) {
        ZuulProperties.ZuulRoute zuulRoute = super.getZuulRoute(adjustedPath);
        log.warn("===================================================================");
        log.warn(zuulRoute.toString());
        return zuulRoute;
    }
}
