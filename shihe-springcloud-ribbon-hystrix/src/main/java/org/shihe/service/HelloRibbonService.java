package org.shihe.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloRibbonService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-22 9:29
 * @Version 1.0
 */
@Service
public class HelloRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hystrixError")
    public String helloRibbonHystrix(){
        return restTemplate.getForObject("http://spring-cloud-eureka-client/hello",String.class);
    }

    public String hystrixError(){
        return "sorry hystrix error!!";
    }
}
