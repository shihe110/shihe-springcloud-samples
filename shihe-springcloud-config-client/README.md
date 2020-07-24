## spring-cloud-config-client配置中心客户端

## step 1
新建项目添加依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
// 只添加此依赖即可，其他依赖按需添加
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

## step 2
配置bootstrap.properties
```xml
server.port=9007
spring.application.name=config-client
eureka.client.service-url.defaultZone=http://localhost:8000/eureka/

spring.cloud.config.label=master
spring.cloud.config.name=config-client
spring.cloud.config.profile=dev
spring.cloud.config.uri=http://localhost:9006/
```
这里有一个坑，启动时控制台报错：日志显示Fetching config from server at : http://localhost:8888/
从该地址取配置，但其实配置server.port=9007应该是从http://localhost:9007/ 加载配置，这里涉及到springcloud
配置文件优先级的问题；SpringCloud里面有个“启动上下文”,主要是用于加载远端的配置,也就是加载ConfigServer里面的配置,
默认加载顺序为:加载bootstrap.*里面的配置 --> 链接configserver,加载远程配置 --> 加载application.*里面的配置; 
总结:这里需要借助于“启动上下文”来处理加载远程配置；所以只要将配置文件改为bootstrap.properties或bootstrap.yml文件即可。

参考相关博文：https://www.cnblogs.com/niechen/p/8968204.html

## step 3

测试代码

```java
@RestController
public class ConfigClientController {

    @Value("${shihe.name}")
    String name;

    @GetMapping("/hello")
    public String hello(){
        return "hello "+name;
    }
}
```

## 配置中心服务化且实现高可用
配置中心server端改造：
添加注册中心依赖
主类开启服务发现
application配置注册中心地址等

配置中心client端改造：
依赖eureka
主类开启服务发现注解
bootstrap添加注册中心地址及配置中心服务id

配置中心server服务，启动多个实例，且注册到注册中心提供配置服务实现配置中心高可用

