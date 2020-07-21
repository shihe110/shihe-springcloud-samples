## 服务调用之 Ribbon+RestTemplate

## step 1
添加依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

## step2
开启eurekaclient并注入RestTemplate
```java
@SpringBootApplication
@EnableEurekaClient
public class ShiheSpringcloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudRibbonApplication.class, args);
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
```
## step 3
新建调用服务代码

```java
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    /**
     * 调用服务名为：spring-cloud-eureka-client的服务
     * @return
     */
    public String hello(){
        return restTemplate.getForObject("http://spring-cloud-eureka-client/hello",String.class);
    }
}

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello/ribbon")
    public String hello(){
        return helloService.hello();
    }
}
```
## step 4

启动注册中心：spring-cloud-eureka-server 端口8000

![注册中心](https://github.com/shihe110/shihe-springcloud-samples/blob/master/shihe-springcloud-ribbon/metadata/ribbon-server.png)

启动服务：spring-cloud-eureka-client 端口9000

启动调用ribbon服务并测试：spring-cloud-ribbon 端口9001

测试地址：http://localhost:9001/hello/ribbon

![调用结果](https://github.com/shihe110/shihe-springcloud-samples/blob/master/shihe-springcloud-ribbon/metadata/ribbon-result.png)

