package org.shihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShiheSpringcloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudEurekaClientApplication.class, args);
    }

}
