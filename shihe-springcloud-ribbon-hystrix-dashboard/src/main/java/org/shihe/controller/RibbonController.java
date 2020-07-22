package org.shihe.controller;

import org.shihe.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RibbonController
 * @Description TODO
 * @Author admin
 * @Date 2020-07-22 15:57
 * @Version 1.0
 */
@RestController
public class RibbonController {

    @Autowired
    RibbonService ribbonService;

    @GetMapping("/hello/ribbon")
    public String hello(){
        String result = ribbonService.hello();
        System.out.println("调用结果》》》》"+result);
        return result;
    }
}
