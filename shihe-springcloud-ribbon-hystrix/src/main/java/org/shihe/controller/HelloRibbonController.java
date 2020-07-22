package org.shihe.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.shihe.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloRibbonController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-22 9:33
 * @Version 1.0
 */
@RestController
public class HelloRibbonController {

    @Autowired
    HelloRibbonService helloRibbonService;

    @GetMapping("/hello/hystrix")
    public String helloRibbonHystrix(){
        String result = helloRibbonService.helloRibbonHystrix();
        System.out.println("调用结果》》》》"+result);
        return result;
    }
}
