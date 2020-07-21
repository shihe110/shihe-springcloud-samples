package org.shihe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloService
 * @Description 指定调用服务名称
 * @Author admin
 * @Date 2020-07-21 17:26
 * @Version 1.0
 */
@FeignClient(value = "spring-cloud-eureka-client")
public interface HelloFeignService {
    /**
     * 调用spring-cloud-eureka-client服务的hello方法
     * @return
     */
    @GetMapping(value = "/hello")
    public String helloFeign();
}
