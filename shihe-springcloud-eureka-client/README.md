## 服务发现 Service Discovery: Eureka Clients
[Service Discovery: Eureka Clients官方文档](https://projects.spring.io/spring-cloud/spring-cloud.html#_service_discovery_eureka_clients)

## step 1

添加依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## step 2
开启eureka client
```java
@SpringBootApplication
@EnableEurekaClient // 开启eureka客户端 也可以使用@EnableDiscoveryClient
public class ShiheSpringcloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudEurekaClientApplication.class, args);
    }

}
```

## step 3

新建hello服务

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello spring cloud eureka client";
    }
}
```

## step 4
配置application
```xml
server.port=9000
spring.application.name=spring-cloud-eureka-client # 服务名称
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/ # 注册中心地址

```

## 测试eureka client

http://localhost:9000/hello
```xml
hello spring cloud eureka client
```

## 查看eureka server 服务注册情况

http://localhost:8000/

```xml
注册中心发现服务实例：
Instances currently registered with Eureka
Application	AMIs	Availability Zones	Status
SPRING-CLOUD-EUREKA-CLIENT	n/a (1)	(1)	UP (1) - admin-PC:spring-cloud-eureka-client:9000
```