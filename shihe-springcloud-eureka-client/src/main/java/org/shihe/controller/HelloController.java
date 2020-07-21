package org.shihe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-21 15:29
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello spring cloud eureka client";
    }
}
