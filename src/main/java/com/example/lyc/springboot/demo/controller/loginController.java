package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.dto.LoginRequestDTO;
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

import java.util.Collections;

@Controller
@RequestMapping("/login")
public class loginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    // 登录页面
    @GetMapping
    public String login() {
        return "login"; // 返回login.html
    }

    
   // 登录接口
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
    // 微信登录
    @GetMapping("/wechat")
    public ModelAndView wechatLogin() {
        // 这里应该是重定向到微信的授权页面，具体URL根据实际情况填写
        return new ModelAndView("redirect:https://open.weixin.qq.com/connect/qrconnect?appid=YOUR_APP_ID&redirect_uri=YOUR_REDIRECT_URI&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect");
    }

    // 微信回调
    @GetMapping("/wechat/callback")
    public String wechatCallback(String code, String state) {
        // 处理回调，获取access_token等
        return "userProfile";
    }
}