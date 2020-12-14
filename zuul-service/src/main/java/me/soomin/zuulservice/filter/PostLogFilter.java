package me.soomin.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@Component
@Slf4j
public class PostLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1001;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        Long startTime = (Long)request.getAttribute("startTime");
        Long now = System.currentTimeMillis();
        log.warn("======================================================================================================================================");
        log.warn("Post Filter Active : End Request {} TO {} | Processing Time : {} seconds | End Time : {}",request.getMethod(),request.getRequestURI(),(now-startTime)/1000.0, ZonedDateTime.now());
        log.warn("======================================================================================================================================");
        return null;
    }
}
