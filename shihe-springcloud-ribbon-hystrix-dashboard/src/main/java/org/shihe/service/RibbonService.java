package org.shihe.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RibbonService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-22 15:55
 * @Version 1.0
 */
@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hystrixError")
    public String hello(){
        return restTemplate.getForObject("http://spring-cloud-eureka-client/hello",String.class);
    }

    public String hystrixError(){
        return "sorry hystrix error!!";
    }
}
