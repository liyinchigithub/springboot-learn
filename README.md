# lyc.springboot.demo

这是一个SpringBoot学习项目

## 版本
* jdk 17
* Spring Boot 3.1.2
* Mybatis plus 3.5.3.2

## 技术栈
* Mybatis
* Mybatis-Plus
* Swagger2
* Lombak
* jackjson
* Druid
* Redis
* RabbitMQ
* tomcat
* Spring Security
* Spring Boot Admin
* Spring Boot Actuator
* Spring Boot DevTools
* Spring Boot Web
* Spring Boot Test
* Spring Boot Mail
* Spring Boot Quartz
* Spring Boot JPA
* Spring Boot Data Redis
* Spring Boot Data MongoDB
* Spring Boot Data Elasticsearch
* Spring Boot Data JDBC
* Spring Boot Data JPA
* Spring Boot Data REST
* Spring Boot Data Neo4j
* Spring Boot Data Solr
* Spring Boot Data LDAP
* Spring Boot Data Redis
* Spring Boot Data Cassandra
* Spring Boot Data Couchbase



## 项目结构

```
lyc.springboot.demo
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── lyc
│   │   │           └── springboot
│   │           └── demo
│   │               └── common
│   │                   └── api
│   │                   └── config
│   │                   └── constant
│   │                   └── exception
│   │                   └── utils
│   │               └── config
│   │               └── controller
│   │               └── dao
│   │               └── dto
│   │               └── entity
│   │               └── mapper
│   │               └── service
│   │               └── service.impl
│   │   └── resources
│   │       └── application.yml
│   └── test
│       └── java
│           └── com
│               └── lyc
│                   └── springboot
│                       └── demo
│                           └── LycApplicationTests.java
└── README.md

```

##  项目结构
* common
* service层 
  * 用于通用业务逻辑
* controller层
  * 用于对外暴露接口
* dao层
  * 用于数据库操作
* entity层 
  * 实体类
* mapper层 
  * 用于数据库操作
* service.impl层 
  * service接口实现类
* dto层
  *  用于数据传输
* config
  *  用于配置文件
* utils类
  *  工具类
* exception类
  *  异常类

User实体类 -> UserController -> interface UserService -> class UserServiceImpl -> UserMapper -> UserMapper.xml

## 项目依赖
pom.xml

## 项目配置

* 数据库配置
>application.properties

* 切换环境
>src/main/resources/application.yml

开发环境
```yaml
spring:
  profiles:
    active:
      - dev
```  

产线环境
```yaml
spring:
  profiles:
    active:
      - prod
```

## 启动
* dev
```bash
mvn spring-boot:run
```

##  打jar包

```bash
mvn clean package -Dmaven.test.skip=true
```
* 生成jar包在target目录下
>target/lyc.springboot.demo-0.0.1-SNAPSHOT.jar

## 运行jar包

```bash
java -jar lyc.springboot.demo.jar
```


# 常用命令

```bash
mvn clean package -Dmaven.test.skip=true
mvn clean install
```

# swagger接口文档

>http://localhost:8088/swagger-ui.html

# 全局处理

##  处理全局异常

>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

##  枚举异常处理
>com.lyc.springboot.demo.common.exception.BusinesusinessMsgEnums

##  处理所有不可知的异常
>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

##  处理空指针异常

## 处理数组越界异常

## 处理其他异常

## 处理自定义异常

# 全局返回结果处理

>com.lyc.springboot.demo.common.config.ResultConfig

## 处理成功返回结果

## 处理失败返回结果

# 统一日志处理

>com.lyc.springboot.demo.common.config.LogAspect

## 处理日志切面




# 常见问题

1.端口占用

mac 查看进程占用
```bash

lsof -i:8088
kill -s 9 进程号

```

2. 

3. 

