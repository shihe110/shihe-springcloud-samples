package org.shihe.controller;

import org.shihe.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-21 16:41
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/ribbon")
    public String hello(){
        String result = helloService.hello();
        System.out.println("调用spring-cloud-eureka-client结果："+result);
        return result;
    }
}
