package org.shihe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-24 9:54
 * @Version 1.0
 */
@RestController
public class ConfigClientController {

    @Value("${shihe.name}")
    String name;

    @GetMapping("/hello")
    public String hello(){
        return "hello "+name;
    }
}
