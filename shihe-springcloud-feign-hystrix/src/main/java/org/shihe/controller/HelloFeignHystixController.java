package org.shihe.controller;

import org.shihe.HelloHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloFeignController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-21 17:32
 * @Version 1.0
 */
@RestController
public class HelloFeignHystixController {

    @Autowired
    HelloHystrixService helloHystrixService;

    @RequestMapping("/hello/feign")
    public String index() {
        return helloHystrixService.hello();
    }
}
