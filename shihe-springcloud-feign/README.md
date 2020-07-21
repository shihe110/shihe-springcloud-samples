## 服务调用之 Feign

## step 1

添加依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

## step 2

配置application

```xml
server.port=9002 # 服务端口
spring.application.name=spring-cloud-feign # 服务名称
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/ # 注册中心
```

## step 3

开启eureka client @EnableEurekaClient 或 @EnableDiscoveryClient
开启feign配置 @EnableFeignClients

```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShiheSpringcloudFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudFeignApplication.class, args);
    }
}
```

## step 4

定义feign调用接口-并指定调用服务

```java
@FeignClient(value = "spring-cloud-eureka-client")
public interface HelloFeignService {
    /**
     * 调用spring-cloud-eureka-client服务的hello方法
     * @return
     */
    @GetMapping(value = "/hello")
    public String helloFeign();
}

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
```

## step 5

测试调用：http://localhost:9002/hello/feign

注册中心

![注册中心]()

调用结果

![调用结果]()