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
│   │               └── Log
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

User实体类 -> UserController ->  UserService.interface ->  UserServiceImpl.java -> UserMapper.interface -> UserMapper.xml

在一个典型的Spring Boot和MyBatis的项目中，这些类和接口通常位于以下的层：

1. User（实体类）：这是一个模型类，代表了你的业务领域中的一个实体。它通常位于模型层（Model）。

2. UserController：这是一个控制器类，负责处理HTTP请求和返回HTTP响应。它通常位于控制器层（Controller）。

3. UserService（接口）：这是一个服务接口，定义了一些业务操作。它通常位于服务层（Service）。

4. UserServiceImpl（类）：这是UserService接口的一个实现类，提供了具体的业务逻辑。它也位于服务层（Service）。

5. UserMapper（接口）：这是一个MyBatis的映射器接口，定义了一些与数据库交互的操作。它通常位于数据访问层（DAO或Repository）。

6. UserMapper.xml：这是一个MyBatis的映射文件，提供了UserMapper接口中定义的操作的SQL查询。它也位于数据访问层（DAO或Repository）。

7. UserDTO（Data Transfer Object）通常用于 服务层 和 控制器层 之间的数据传输。它通常包含了客户端需要的数据，而不是数据库中的所有数据。这样可以减少不必要的数据传输，提高应用程序的性能。 在分层架构中，UserDTO通常位于服务层（Service）和控制器层（Controller）之间。 服务层 会从数据库中获取数据（通常是User实体），然后将这些数据转换为UserDTO，并传递给控制器层。控制器层然后将UserDTO转换为HTTP响应。


这种分层的架构可以使你的代码更加模块化，更容易测试和维护。每一层都有其特定的职责，这样可以降低各层之间的耦合度，提高代码的可重用性。



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

> http://localhost:8088/swagger-ui/index.html?urls.primaryName=public#/

<img width="1429" alt="image" src="https://github.com/liyinchigithub/lyc.springboot.demo/assets/19643260/eea042be-b835-4434-be4a-c98930333e07">


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








# 常见问题

1.端口占用

mac 查看进程占用
```bash

lsof -i:8088
kill -s 9 进程号

```



