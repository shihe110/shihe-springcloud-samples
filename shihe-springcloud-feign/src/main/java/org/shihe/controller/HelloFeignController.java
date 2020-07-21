package org.shihe.controller;

import org.shihe.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloFeignController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-21 17:32
 * @Version 1.0
 */
@RestController
public class HelloFeignController {
    @Autowired
    HelloFeignService helloFeignService;
    @GetMapping("/hello/feign")
    public String helloFeign(){
        String result = helloFeignService.helloFeign();
        System.out.println(">>>>>调用结果："+result);
        return result;
    }
}
