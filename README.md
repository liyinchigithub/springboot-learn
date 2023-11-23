# springboot-learn

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

# restfull API

>com.example.lyc.springboot.demo.controller.UserController

## GET

* 示例1：
```java
   /**
     * @author: liyinchi
     * @description 通过获取所有用户信息
     * @mark
     * */
    @Operation(summary = "获取所有用户", description = "返回所有用户的列表")
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public BaseResponse<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream().map(this::convertToDto).collect(Collectors.toList());
        log.info("=======getAllUsers: " + userDTOs);
        return BaseResponse.success(userDTOs);
    }
```


* 返回数据 List
  
  <img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/7758a36e-703f-40e0-a58e-4de8d6d96267">

* 示例2：
```java
   /**
     * @author: liyinchi
     * @description 通过ID获取用户信息
     * @mark    /getUserById/{id}
     * */
    @Operation(summary = "通过ID获取用户", description = "返回指定ID的用户")
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public BaseResponse<UserDTO> getUserById(@Parameter(description = "用户ID", required = true) @PathVariable int id) {
        User user = userService.getUserById(id);
        log.info("=======getUserById user:{}", user);
        return BaseResponse.success(convertToDto(user));
    }
```
* 返回数据 List
  
<img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/5d0ebcf0-5a69-4b70-9d6a-fcd9ea79a0ba">

* 示例3：
```java
     /**
     * @author: liyinchi
     * @description 通过ID获取用户信息
     * @mark    ?id=1&name=liyinchi
     * */
    @Operation(summary = "通过ID参数获取用户", description = "返回指定ID的用户")
    @RequestMapping(value = "/getUserByIdParam", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public BaseResponse<UserDTO> getUserByIdParam(@Parameter(description = "用户ID", required = true) @RequestParam("id") int id) {
        User user = userService.getUserById(id);
        log.info("=======getUserByIdParam user:{}", user);
        return BaseResponse.success(convertToDto(user));
    }
```

* 返回数据 List
  
<img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/00b34bc9-9596-49b8-943e-2dc4cf356e62">


## POST

* 示例1：

```java
   /**
     * @author: liyinchi
     * @description 新增用户
     * @mark json
     * */
    // 定义一个处理POST请求的方法，路径为"/addUser"，返回的数据类型为JSON
    @Operation(summary = "新增用户", description = "通过JSON数据新增用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    // 该方法接收一个参数，即UserDTO对象，这个对象是通过@RequestBody注解从请求体中获取的
    public BaseResponse<UserIdResponseDTO> addUser(@Parameter(description = "用户数据", required = true) @RequestBody UserDTO userDto) {
        // 调用convertToEntity方法，将UserDTO对象转换为User对象
        User user = convertToEntity(userDto);
        // 调用userService的addUser方法，将User对象添加到数据库中
        int newUserId = userService.addUser(user);
        // 记录日志，输出添加的User对象的信息
        log.info("=======addUser:{}", user);
        // 返回一个表示操作成功的BaseResponse对象
        return BaseResponse.success(new UserIdResponseDTO(newUserId));
    }
```

* 返回数据 Object

<img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/50cf6d7a-f670-46bf-969e-4fc7512cc9d0">

* 示例2：

```java
    /**
     * @author: liyinchi
     * @description 新增用户
     * @mark 表单
     *
     * */
    // 定义一个处理POST请求的方法，路径为"/addUserFormData"，返回的数据类型为JSON
    @Operation(summary = "新增用户（表单）", description = "通过表单数据新增用户")
    @RequestMapping(value = "/addUserFormData", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    // 该方法接收三个参数，分别是id，userName和password，这些参数都是通过@RequestParam注解从请求中获取的
    public BaseResponse<UserIdResponseDTO> addUserFormData(@Parameter(description = "用户名", required = true) @RequestParam("userName") String userName,
                                                           @Parameter(description = "密码", required = true) @RequestParam("password") String password){
        // 创建一个新的UserDTO对象
        UserDTO userDto = new UserDTO();
        // 将从请求中获取的参数设置到UserDTO对象中
        userDto.setUserName(userName);
        userDto.setPassword(password);
        // 调用convertToEntity方法，将UserDTO对象转换为User对象
        User user = convertToEntity(userDto);
        // 记录日志，输出添加的User对象的信息
        log.info("=======addUserFormData:{}", user);
        // 调用userService的addUser方法，将User对象添加到数据库中
        int newUserId = userService.addUser(user);
        // 返回一个表示操作成功的BaseResponse对象
        return BaseResponse.success(new UserIdResponseDTO(newUserId));
    }
```

* 返回数据 Object
  
<img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/ba339d0a-bad1-4d7b-ae50-1a90061494eb">




## PUT

* 示例1：

```java
/**
     * @author: liyinchi
     * @description 更新用户
     * @mark json
     * */
    @Operation(summary = "更新用户", description = "通过JSON数据更新用户")
    // 定义一个处理PUT请求的方法，路径为"/updateUser"，返回的数据类型为JSON
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT,produces = "application/json; charset=UTF-8")
    // 该方法接收一个参数，即UserDTO对象，这个对象是通过@RequestBody注解从请求体中获取的
    public BaseResponse<UpdateUserResponseDTO> updateUser(@Parameter(description = "用户数据", required = true) @RequestBody UserDTO userDto) {
        // 调用convertToEntity方法，将UserDTO对象转换为User对象
        User user = convertToEntity(userDto);
        // 调用userService的updateUser方法，将User对象的信息更新到数据库中
        int updates = userService.updateUser(user);
        // 记录日志，输出更新的User对象的信息
        log.info("=======updateUser:{}", user);
        // 返回一个表示操作成功的BaseResponse对象
        return BaseResponse.success(new UpdateUserResponseDTO(user.getId(), updates));
    }

```

* 返回数据

  <img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/69744455-2793-40b9-9372-e8e8204839c2">



## DELETE

* 示例1：

```java
/**
     * @author: liyinchi
     * @description 删除用户
     * @param request object {"id":4}
     * @return object
     * */
    // 定义一个处理DELETE请求的方法，路径为"/deleteUser"，返回的数据类型为JSON
    @Operation(summary = "删除用户", description = "通过JSON数据删除用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE,produces = "application/json; charset=UTF-8")
    // 该方法接收一个参数，即DeleteUserRequestDTO对象，这个对象是通过@RequestBody注解从请求体中获取的
    public BaseResponse<DeleteUserResponseDTO>  deleteUser(@Parameter(description = "删除用户请求数据", required = true)  @RequestBody DeleteUserRequestDTO request) {
        // 调用userService的deleteUser方法，根据请求中的id删除数据库中的用户
        int updates = userService.deleteUser(request.getId());// 获取请求参数id值
        // 记录日志，输出删除的用户的请求信息
        log.info("=======deleteUser:{}", request);
        // 返回一个表示操作成功的BaseResponse对象
        return BaseResponse.success(new DeleteUserResponseDTO(request.getId(), updates));
    }
```

* 返回数据 

<img width="400" height="400"  alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/a4181ff1-5a87-492b-8230-4af94510e40d">



* 示例2：

```java
  /**
     * @author: liyinchi
     * @description 删除用户
     * @mark  请求参数在URI中
     * @param id 用户ID
     * @return String
     *
     * */
    @Operation(summary = "通过ID删除用户", description = "删除指定ID的用户")
    @RequestMapping(value = "/deleteUserPath/{id}", method = RequestMethod.DELETE,produces = "application/json; charset=UTF-8")
    public BaseResponse<UserIdResponseDTO> deleteUserPath(@Parameter(description = "用户ID", required = true) @PathVariable int id) { // id在URI中
        userService.deleteUser(id);
        log.info("=======deleteUserPath:{}", id);
        return BaseResponse.success(new UserIdResponseDTO(id));
    }
```

* 返回数据 

<img width="400" height="400"  alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/c889e1b4-9319-4ba9-9adc-d83cfed60f55">


* 示例3：

```java
 /**
     * @author: liyinchi
     * @description 删除用户
     * @mark 请求参数在URI中 ?id=
     * @param id 用户ID
     * @return object
     *
     * */
    @Operation(summary = "通过ID参数删除用户", description = "删除指定ID的用户")
    @RequestMapping(value = "/deleteUserParam", method = RequestMethod.DELETE,produces = "application/json; charset=UTF-8")
    public BaseResponse<UserIdResponseDTO> deleteUserParam(@Parameter(description = "用户ID", required = true) @RequestParam("id") int id) { // id在URI中
        userService.deleteUser(id);
        log.info("=======deleteUserParam:{}", id);
        return BaseResponse.success(new UserIdResponseDTO(id));
    }

```

* 返回数据 

<img width="400" height="400" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/36db82b5-e195-4bf3-a4c7-f3551b30f47f">



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



