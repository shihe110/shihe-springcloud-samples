## 熔断监控 hystrix-dashboard

## step 1
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
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```

## step 2
新建ribbon调用代码见：shihe-spring-cloud-ribbon
启动类配置监控：
```java
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard // 监控
public class ShiheSpringcloudRibbonHystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudRibbonHystrixDashboardApplication.class, args);
    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```
## step 3 
配置application
```xml
spring.application.name=hystrix-dashboard
server.port=9005
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/

```
## step 4

测试：http://localhost:9005/hystrix
![监控页面](https://mmbiz.qpic.cn/mmbiz_png/a2yUAKXzX0YZflFCgI9jjhUPSHrAcfc5ZnmMozgqXz7f2iagxxnaf2PQQvXLyxbaSFsuXOJdM6Gib6CxoiavLaZ7A/0?wx_fmt=png)
