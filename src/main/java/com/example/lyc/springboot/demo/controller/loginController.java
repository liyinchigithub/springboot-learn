package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.dto.LoginRequestDTO;
import com.example.lyc.springboot.demo.entity.User;
import com.example.lyc.springboot.demo.entity.WechatUser;
import com.example.lyc.springboot.demo.service.UserService;
import com.example.lyc.springboot.demo.service.WechatService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.lyc.springboot.demo.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

@Controller
@RequestMapping("/login")
public class loginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private final WechatService wechatService;
    @Autowired
    private UserService userService;

    public loginController(WechatService wechatService) {
        this.wechatService = wechatService;
    }

    @Autowired
    public loginController(WechatService wechatService, AuthenticationManager authenticationManager) {
        this.wechatService = wechatService;
        this.authenticationManager = authenticationManager;
    }

    // 登录页面
    @GetMapping
    public String login() {
        return "login"; // 返回login.html
    }

    
   // 账号密码登录
   @PostMapping("/perform_login")
    public ResponseEntity<?> performLogin(@RequestBody LoginRequestDTO loginRequest) {
        try {
            System.out.println("Received login request for user: " + loginRequest.getUsername());
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            String jwt = JwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok().body(Collections.singletonMap("token", jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    // H5微信登录
    @GetMapping("/wechat")
    public ModelAndView wechatLogin() {
        String url = "https://open.weixin.qq.com/connect/qrconnect?appid=" + 
                     "${wechat.appid}" + 
                     "&redirect_uri=" + 
                     "${wechat.redirect.uri}" + 
                     "&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
        // 这里应该是重定向到微信的授权页面，具体URL根据实际情况填写
        return new ModelAndView("redirect:" + url);
    }

    // H5微信回调
    @GetMapping("/wechat/callback")
    public String wechatCallback(@RequestParam String code, @RequestParam String state) {
       // 调用服务获取access_token
       WechatService.AccessTokenResponse tokenResponse = wechatService.getAccessToken(code, state);
       String accessToken = tokenResponse.getAccessToken();
       String openid = tokenResponse.getOpenid();
       // 使用access_token获取用户信息
       WechatUser wechatUser = wechatService.getUserInfo(accessToken, openid);
       User user = userService.loginOrCreateWechatUser(wechatUser);
       // 根据业务逻辑处理用户信息，例如创建用户、生成JWT等
       return "userProfile"; // 或者重定向到其他页面
    }

    // 验证微信回调
    @GetMapping("/wechat/verify")
    public String verifyWechatToken(
            @RequestParam(name = "signature") String signature,
            @RequestParam(name = "timestamp") String timestamp,
            @RequestParam(name = "nonce") String nonce,
            @RequestParam(name = "echostr") String echostr) {
            //  调试输出
            System.out.println("Received verify request for user: " + signature + timestamp + nonce + echostr);
        if (checkSignature(signature, timestamp, nonce)) {
            return echostr; // 验证成功，返回echostr
        } else {
            return "failure";
        }
    }
    // 验证签名
    private boolean checkSignature(String signature, String timestamp, String nonce) {
        String token = "123456"; // 这里填写你在微信公众平台上设置的Token
        String[] arr = new String[] { token, timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String str : arr) {
            content.append(str);
        }
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String calcSignature = DigestUtils.sha1Hex(content.toString());
        return calcSignature.equals(signature);
    }

    // APP登录
    @GetMapping("/app")
    public ResponseEntity<?> appLogin(@RequestParam String code) {
        // 使用 "authorization_code" 替换 "client_credential"
        String accessToken = wechatService.getAccessToken(code, "authorization_code").getAccessToken();
        // 由于 "client_credential" 不返回 openid，这里假设你已经有了正确的 code 来获取 openid
        String openid = wechatService.getAccessToken(code, "authorization_code").getOpenid();
        WechatUser user = wechatService.getUserInfo(accessToken, openid);
        // 处理用户信息，生成JWT等
        return ResponseEntity.ok().body(user);
    }
   
}