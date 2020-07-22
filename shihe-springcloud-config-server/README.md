## SpringCloud 配置中心server

## step 0
github新建库文件夹：

https://github.com/shihe110/config-rep/repo

## step 1
添加依赖

```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
```
## step 2
配置application
```xml
spring.cloud.config.server.git.uri=https://github.com/shihe110/config-rep/ // github地址
spring.cloud.config.server.git.searchPaths=repo // 文件夹名称
spring.cloud.config.label=master // github分支
#spring.cloud.config.server.git.username=your username // 公开库可省略
#spring.cloud.config.server.git.password=your password
```
## step 3
开启
```java
@SpringBootApplication
@EnableConfigServer
public class ShiheSpringcloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiheSpringcloudConfigServerApplication.class, args);
    }
}
```

## step 3

启动测试查看：repo下config-client-dev.properties

spring-cloud-config将文件自动转换web接口：
如:

http://localhost:8080/config-client/dev

```jsp
{
"name": "config-client",
"profiles": [
"dev"
],
"label": null,
"version": "fca578c2aaeeed33ba9895dbdd9195403bd2e874",
"state": null,
"propertySources": [
{
"name": "https://github.com/shihe110/config-rep//repo/config-client-dev.properties",
"source": {
"shihe.name": "zhangsan",
"shihe.age": "18"
}
}
]
}
```