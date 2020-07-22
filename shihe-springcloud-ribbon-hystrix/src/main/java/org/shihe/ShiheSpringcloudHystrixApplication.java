package org.shihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现客户端
@EnableHystrix // 开启断路器注解
public class ShiheSpringcloudHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudHystrixApplication.class, args);
    }
    /**
     * 注入RestTemplate并开启负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
