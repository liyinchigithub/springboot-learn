# springboot-learn

这是一个学习SpringBoot入门项目

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
* Druid                           数据库连接池实现
* Redis
* RabbitMQ
* tomcat
* Spring Security                 安全认证和授权
* Spring Boot Admin               管理和监控Spring Boot应用程序
* Spring Boot Actuator            提供生产级的应用特性，如监控和度量
* Spring Boot DevTools            提高开发者的开发效率
* Spring Boot Web                 开发Web应用程序，包括RESTful应用程序
* Spring Boot Test                测试Spring Boot引用过程序
* Spring Boot Mail                发送邮件
* Spring Boot Quartz              定时任务
* Spring Boot JPA                 Java Persistence API（JPA）访问数据库
* Spring Boot Data Redis          Redis访问键值对数据
* Spring Boot Data MongoDB        MongoDB访问文档数据库
* Spring Boot Data Elasticsearch  Elasticsearch进行全文搜索
* Spring Boot Data JDBC           JDBC访问数据库
* Spring Boot Data REST           RESTful API访问数据
* Spring Boot Data Neo4j          Neo4j访问图数据库
* Spring Boot Data Solr           Apache Solr进行全文搜索
* Spring Boot Data LDAP           LDAP访问目录服务
* Spring Boot Data Cassandra      Cassandra访问列存储数据库
* Spring Boot Data Couchbase      Couchbase访问文档数据库。



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
│   │               └── hadnler
│   │                   └── 
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
* 切面类
  *  日志切面

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


# 全局异常处理

>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

##  业务异常（枚举异常）
>com.lyc.springboot.demo.common.exception.BusinesusinessMsgEnums

## 参数缺失
>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

```java
 /**
     * 缺少请求参数异常
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseResponse handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return new BaseResponse(400, "缺少必要的请求参数");
    }
```


##  处理空指针异常
>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

```java
 /**
     * 系统异常 预期以外异常
     * @param ex
     * 项目中，我们一般都会比较详细的去拦截一些常见异常，拦截 Exception 虽然可以一劳永逸，但是不利于我们去排查或者定位问题。
     * 实际项目中，可以把拦截 Exception 异常写在 GlobalExceptionHandler 最下面，如果都没有找到，最后再拦截一下 Exception 异常，保证输出信息友好
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return new BaseResponse(500, "系统未知异常，请联系管理员");
    }

```

##  所有不可知的异常(不推荐)
>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

```java
  /**
     * @Description: 所有不可知的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        // 这里可以记录日志，发送通知等
        return new ResponseEntity<>("请求参数错误", HttpStatus.BAD_REQUEST);
    }
```


## 处理数组越界异常

>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler
```java
  /**
     * 处理数组越界异常
     * */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
        log.error("数组越界异常，{}", ex.getMessage());
        return new BaseResponse(500, "数组越界异常了");
    }
```


## 一劳永逸异常
>com.lyc.springboot.demo.common.exception.GlobalExceptionHandler

```java
 /**
     * 系统异常（预期意外）
     * @param ex
     * 项目中，我们一般都会比较详细的去拦截一些常见异常，拦截 Exception 虽然可以一劳永逸，但是不利于我们去排查或者定位问题。
     * 实际项目中，可以把拦截 Exception 异常写在 GlobalExceptionHandler 最下面，如果都没有找到，最后再拦截一下 Exception 异常，保证输出信息友好
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return new BaseResponse(500, "系统未知异常，请联系管理员");
    }
```


# 全局返回结果处理

>com.lyc.springboot.demo.common.api.BaseResponse

## 处理成功返回结果

```java
   public BaseResponse() {
        this.code = 0;
        this.message = "success";
    }
```


## 处理失败返回结果

```java
```


# 统一日志处理

>com.lyc.springboot.demo.common.config.LogAspect



# 文件上传

>com/example/lyc/springboot/demo/controller/UploadController.java

接收上传文件，存放在指定路径下

```java
**
 * 文件上传
 * 限制上传大小、文件格式、存放位置、重命名上传文件
 * */
@Slf4j
@RestController
@RequestMapping("/v1/fileUpload")
@Schema(name="文件上传", description="文件上传")
@Tag(name = "文件上传")
public class UploadController {
    private static final String UPLOAD_DIR = "./upload";

    @PostMapping("/upload")
    public BaseResponse<String> handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId) {
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        // 限制上传文件大小
        if (file.getSize() > 1024 * 1024 * 5) {
            return new BaseResponse<>(1, "File size too large", null);
        }
        // 限制上传文件格式
        if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
            return new BaseResponse<>(1, "Invalid file format", null);
        }

        // Rename the file
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFilename = userId + "_" + timestamp + "_" + originalFilename;

        // Save the file to the server
        Path filePath = Paths.get(UPLOAD_DIR, newFilename);
        try {
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return new BaseResponse<>(1, "Failed to save file", null);
        }

        return new BaseResponse<>(0, "File uploaded successfully", newFilename);
    }
}
```
![image](https://github.com/liyinchigithub/springboot-learn/assets/19643260/d2957a95-cc9e-4e93-9602-8dc251d9d90f)



接收上传文件，存放在阿里云存储上

```java
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.lyc.springboot.demo.commons.api.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class UploadController {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @PostMapping("/upload")
    public BaseResponse<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        String fileExtension = filename.substring(filename.lastIndexOf(".") + 1);
        if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
            return new BaseResponse<>(1, "Invalid file format", null);
        }

        // Create an OSSClient instance
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // Upload the file to OSS
            ossClient.putObject(bucketName, filename, new ByteArrayInputStream(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            return new BaseResponse<>(1, "Failed to upload file", null);
        } finally {
            // Shut down the OSSClient
            ossClient.shutdown();
        }

        return new BaseResponse<>(0, "File uploaded successfully", filename);
    }
}

```

# 生成工具

## 快速实现实体类、mapper、数据库表字段

>com/example/lyc/springboot/demo/util/MybatisGenerator.java

![image](https://github.com/liyinchigithub/springboot-learn/assets/19643260/878198bf-69df-4294-8df9-126b4e74f594)




# 切面

## 日志切面

>com/example/lyc/springboot/demo/handler/LogAspectHandler.java


```yml
@Pointcut：定义一个切面，即上面所描述的关注的某件事入口。
@Before：在做某件事之前做的事。
@After：在做某件事之后做的事。
@AfterReturning：在做某件事之后，对其返回值做增强处理。
@AfterThrowing：在做某件事抛出异常时，处理。
```

* @Before 注解

指定的方法在切面切入目标方法之前执行

可以做一些 log 处理，也可以做一些信息的统计，比如获取用户的请求 url 以及用户的 ip 地址等等
```java
@Aspect
@Slf4j
@Component
public class LogAspectHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 定义一个切面，拦截com.itcodai.course09.controller包和子包下的所有方法
     */
    @Pointcut("execution(* com.example.lyc.springboot.demo..*.*(..))")
    public void pointCut() {}

    /**
     * 在上面定义的切面方法之前执行该方法
     * @param joinPoint jointPoint
     */
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("====doBefore方法进入了====");
        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        log.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);

        // 也可以用来记录一些信息，比如获取请求的url和ip
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 获取请求url
            String url = request.getRequestURL().toString();
            // 获取请求ip
            String ip = request.getRemoteAddr();
            log.info("用户请求的url为：{}，ip地址为：{}", url, ip);
        } else {
            log.info("Not in a request context");
        }
    }

}
```
<img width="1351" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/613174c2-6a0c-4812-beaa-0e9e9d60882d">




* @After 注解 

**指定的方法在切面切入目标方法之后执行**

也可以做一些完成某方法之后的 log 处理
```java
   /**
   * 在上面定义的切面方法之后执行该方法
   * @param joinPoint jointPoint
   */
  @After("pointCut()")
  public void doAfter(JoinPoint joinPoint) {
          log.info("====doAfter方法进入了====");
          Signature signature = joinPoint.getSignature();
          String method = signature.getName();
          log.info("方法{}已经执行完", method);
          }
```

<img width="1340" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/45bc19eb-30ba-481b-8f78-6721daf1f8da">


* @AfterReturning 注解

用来捕获切入方法执行完之后的返回值，对返回值进行业务逻辑上的增强处理

**[需要注意的是]**
在 @AfterReturning注解 中，属性 returning 的值必须要和参数保持一致，否则会检测不到。该方法中的第二个入参就是被切方法的返回值，在 doAfterReturning 方法中可以对返回值进行增强，可以根据业务需要做相应的封装。

```java
    /**
     * 在上面定义的切面方法返回后执行该方法，可以捕获返回对象或者对返回对象进行增强
     * @param joinPoint joinPoint
     * @param result result
     */
    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {

        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getName();
        log.info("方法{}执行完毕，返回参数为：{}", classMethod, result);
        // 实际项目中可以根据业务做具体的返回值增强
        log.info("对返回参数进行业务上的增强：{}", result + "增强版");
    }
```

<img width="1343" alt="image" src="https://github.com/liyinchigithub/springboot-learn/assets/19643260/b66bd351-27ae-4f94-ba30-87cf72d55d7e">


* @AfterThrowing 注解

当被切方法执行时抛出异常时，会进入 @AfterThrowing 注解的方法中执行，在该方法中可以做一些异常的处理逻辑。

要注意的是 throwing 属性的值必须要和参数一致，否则会报错。该方法中的第二个入参即为抛出的异常。
```java
/**
     * 在上面定义的切面方法执行抛异常时，执行该方法
     * @param joinPoint jointPoint
     * @param ex ex
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        Signature signature = joinPoint.getSignature();
        String method = signature.getName();
        // 处理异常的逻辑
        log.info("执行方法{}出错，异常为：{}", method, ex);
    }
```

annotation() 方式是针对某个注解来定义切面，比如我们对具有@GetMapping注解的方法做切面，可以如下定义切面：
```java
@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
public void annotationCut() {}
```

# 静态资源

Spring Boot 的默认静态目录为 resources/static


# 事务

## UserMapper.xml


```xml

```

## UserServiceImpl.java

```java

```

* SQL异常不能被识别回滚
SpringBoot 默认的事务规则是遇到 **运行异常（RuntimeException）** 和）**程序错误（Error）** 才会回滚。
比如抛出的 RuntimeException 就没有问题，但是抛出 **SQLException** 就无法回滚了。
针对非运行时异常，如果要进行事务回滚的话，可以在 **@Transactional** 注解中使用 **rollbackFor** 属性来指定异常，比如 **@Transactional(rollbackFor = Exception.class)**，这样就没有问题了，所以在实际项目中，一定要指定异常。

* 异常被 ”吃“ 掉
这个标题很搞笑，异常怎么会被吃掉呢？
还是回归到现实项目中去，我们在处理异常时，有两种方式：
  **要么抛出去，让上一层来捕获处理；**
  **要么把异常 try catch 掉，在异常出现的地方给处理掉。**
  就因为有这中 try…catch，所以导致异常被 ”吃“ 掉，事务无法回滚。

那这种怎么解决呢？
  **直接往上抛，给上一层来处理即可，千万不要在事务中把异常自己 ”吃“ 掉。**


* 事务范围这个东西比上面两个坑埋的更深！


举个实际的场景，比如：
一个数据库中，针对某个用户，只有一条记录，下一个插入动作过来，会先判断该数据库中有没有相同的用户，如果有就不插入，就更新，没有才插入，所以理论上，数据库中永远就一条同一用户信息，不会出现同一数据库中插入了两条相同用户的信息。
但是在压测时，就会出现上面的问题，数据库中确实有两条同一用户的信息，分析其原因，在于事务的范围和锁的范围问题。


那这种怎么解决呢？

**根本原因**：也就是说，在加锁的那部分代码执行完之后，锁释放掉了，但是事务还没结束，此时另一个线程进来了，事务没结束的话，第二个线程进来时，数据库的状态和第一个线程刚进来是一样的。
即由于mysql Innodb引擎的默认隔离级别是可重复读（在同一个事务里，SELECT的结果是事务开始时时间点的状态），线程二事务开始的时候，线程一还没提交完成，导致读取的数据还没更新。
第二个线程也做了插入动作，导致了脏数据。

这个问题可以避免，第一，把事务去掉即可（不推荐）；第二，在调用该 service 的地方加锁，保证锁的范围比事务的范围大即可。

# 监听器


# 拦截器


# Redis


## 分布式锁

## 分布式事务

## 分布式ID

## 分布式缓存

# shiro



# activeMQ









# 常见问题

1.端口占用

mac 查看进程占用
```bash

lsof -i:8088
kill -s 9 进程号

```



