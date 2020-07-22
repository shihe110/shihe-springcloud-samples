package org.shihe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ShiheSpringcloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudConfigServerApplication.class, args);
    }

}
