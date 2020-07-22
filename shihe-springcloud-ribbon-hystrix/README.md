## SpringCloud之断路器（Netflix Hystrix）

## ribbon调用服务使用Hystrix
## step 1

新建项目添加依赖

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
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```
## step 2
配置application
```xml
spring.application.name=spring-cloud-hystrix
server.port=9003
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/
```
## step 3

新建服务调用程序并在启动类开启-断路器注解@EnableHystrix
```java
// 开启断路器
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

// ribbon调用服务
@Service
public class HelloRibbonService {
   
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hystrixError")
    public String helloRibbonHystrix(){
        return restTemplate.getForObject("http://spring-cloud-eureka-client/hello",String.class);
    }

    public String hystrixError(){
        return "sorry hystrix error!!";
    }
}
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
```

## step 4

启动测试：
1.启动注册中心spring-cloud-eureka-server

![注册中心结果](https://mmbiz.qpic.cn/mmbiz_png/a2yUAKXzX0YZflFCgI9jjhUPSHrAcfc5UNibbZr0QpRRYBUj67ia5Y2wIMVecUtzUGSv9SK96TLS66l8P2IR8KGQ/0?wx_fmt=png)

2.启动spring-cloud-eureka-client 

![服务提供者](https://mmbiz.qpic.cn/mmbiz_png/a2yUAKXzX0YZflFCgI9jjhUPSHrAcfc5wV4kYt8XDDYzEJ36tCATW6tW6Gm9k80E8ibJVTWr7U9uePKDHt2xPrw/0?wx_fmt=png)

3.启动spring-cloud-hystrix 
4.检查调用情况

![服务消费者](https://mmbiz.qpic.cn/mmbiz_png/a2yUAKXzX0YZflFCgI9jjhUPSHrAcfc5Q1x9GKrX4ia8IBuCUB2tjqfTCyESzLibEBMdI6gibm4mKLFFPH72vEOew/0?wx_fmt=png)


5.关闭spring-cloud-eureka-client服务

![服务故障](https://mmbiz.qpic.cn/mmbiz_png/a2yUAKXzX0YZflFCgI9jjhUPSHrAcfc5gfnwjJIiaibuhric4kTpQcF43iaMaV8ETsQkabS0grJ2Btl4moKIT2wHaA/0?wx_fmt=png)

6.检查调用情况

![断路器生效](https://mmbiz.qpic.cn/mmbiz_png/a2yUAKXzX0YZflFCgI9jjhUPSHrAcfc5wUnVbficHpjuouAoTWkjclrMibOgSNLmDdIHP47sI6XrTNP5dXmBCJpA/0?wx_fmt=png)

