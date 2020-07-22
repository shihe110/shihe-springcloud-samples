## Feign服务调用使用断路器

## step 0
依赖
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
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

## step 1
新建feign调用
```java
// 1.开启服务发现客户端 2.开启feign客户端 3.开启断路器
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ShiheSpringcloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudFeignApplication.class, args);
    }
}
// 
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
## step 2 
配置断路器
```java
@FeignClient(value = "spring-cloud-eureka-client",fallback = HelloFeignHystrix.class)// 失败回调
public interface HelloFeignService {
    /**
     * 调用spring-cloud-eureka-client服务的hello方法
     * @return
     */
    @GetMapping(value = "/hello")
    public String helloFeign();
}
// 失败回调实现类
@Component
public class HelloFeignHystrix implements HelloFeignService {
    @Override
    public String helloFeign() {
        return "sorry process is error!!";
    }
}
```
## step3
测试调用结果