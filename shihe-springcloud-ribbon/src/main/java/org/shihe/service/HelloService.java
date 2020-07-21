package org.shihe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-21 16:41
 * @Version 1.0
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    /**
     * 调用服务名为：spring-cloud-eureka-client的服务
     * @return
     */
    public String hello(){
        return restTemplate.getForObject("http://spring-cloud-eureka-client/hello",String.class);
    }
}
