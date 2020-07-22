package org.shihe;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "spring-cloud-eureka-client",fallback = HelloHystrixImpl.class)
public interface HelloHystrixService {

    @RequestMapping(value = "/hello")
    public String hello();
}
