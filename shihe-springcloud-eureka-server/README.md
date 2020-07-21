## 服务发现 Service Discovery: Eureka Server
[Service Discovery: Eureka Server官方文档](https://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-eureka-server)

## step1
新建model添加依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
## step2
开启eureka server
```java
@SpringBootApplication
@EnableEurekaServer
public class ShiheSpringcloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudEurekaServerApplication.class, args);
    }

}
```

## step3
配置application
```xml
spring.application.name=spring-cloud-eureka-server #服务名称
server.port=8000 # 服务端口
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/ #服务url

eureka.client.register-with-eureka=false # 不注册本身
eureka.client.fetch-registry=false # 本节点为server节点，不需要同步其他服务节点
```
## step4
测试 http://localhost:8000

![eureka-server](https://www.tutorialspoint.com/spring_boot/images/eureka_server_running_on_port_8761.jpg)

#### 注：spring cloud微服务体系内，注册中心除了Eureka 还有Nacos