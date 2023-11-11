# lyc.springboot.demo

## 版本

* jdk 17
* Spring Boot 3.1.2
* Mybatis plus 3.5.3.2

## 项目介绍

SpringBoot学习项目

* Mybatis
* Mybatis-Plus
* Swagger2
* Lombak
* jackjson
* Druid
* Redis
* RabbitMQ
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

## 项目分层

* common
* service
* controller
* dao
* mapper
* entity
* dto
* service
* config
* utils
* exception
* listener
* constant
* api

## 项目依赖
pom.xml



## 项目启动

### 开发模式启动项目

```bash
mvn spring-boot:run
```

###  打jar包

```bash
mvn clean package -Dmaven.test.skip=true
```

生成jar包在target目录下
>target/lyc.springboot.demo-0.0.1-SNAPSHOT.jar


### 打包运行

```bash
java -jar lyc.springboot.demo.jar
```



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

# 常用命令

```
mvn clean package -Dmaven.test.skip=true
mvn clean install


# 切换环境

>src/main/resources/application.yml

```yaml
# 开发环境
spring:
  profiles:
    active:
      - dev

# 产线环境
spring:
  profiles:
    active:
      - prod
```   

# swagger

http://localhost:8088/swagger-ui.html


# 全局异常处理

>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

## 枚举异常处理
>com.lyc.springboot.demo.common.exception.BusinesusinessMsgEnums

## 处理所有不可知的异常
>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

## 处理空指针异常

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

## 处理日志切面



# 常见问题

1.端口占用

mac 查看进程占用
```bash

lsof -i:8088
kill -s 9 进程号

```

