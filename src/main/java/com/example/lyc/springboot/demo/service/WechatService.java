package com.example.lyc.springboot.demo.service;

import com.example.lyc.springboot.demo.entity.WechatUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
/**
 * 微信服务类
 * 用于获取微信用户信息
 * */ 
@Slf4j
@Service
public class WechatService {
    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.redirect.uri}")
    private String redirectUri;

    @Autowired
    private RestTemplate restTemplate;  // 确保使用@Autowired注解


    public WechatService() {
        this.restTemplate = new RestTemplate();
        // 添加对text/plain类型的支持
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    // 实现根据code获取access_token的逻辑
    // 实现根据access_token获取用户信息的逻辑

    // 通用方法获取access_token
    // 微信服务类中的方法
    public AccessTokenResponse getAccessToken(String code, String grantType) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("appid", appId)
                .queryParam("secret", secret)
                .queryParam("code", code)
                .queryParam("grant_type", grantType);

        String response = restTemplate.getForObject(builder.toUriString(), String.class);
        System.out.println("微信API响应: " + response);
        Gson gson = new Gson();
        AccessTokenResponse tokenResponse = gson.fromJson(response, AccessTokenResponse.class);
        // 调试输出response中的 access_token和openid
        System.out.println("AccessToken: " + tokenResponse.getAccessToken());
        System.out.println("OpenID: " + tokenResponse.getOpenid());
        return tokenResponse;
    }

    // 获取用户信息
    public WechatUser getUserInfo(String accessToken, String openid) {
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.weixin.qq.com/sns/userinfo")
        .queryParam("access_token", accessToken)
        .queryParam("openid", openid)
        .queryParam("lang", "zh_CN");

        String url = builder.toUriString();
        log.info("请求微信用户信息URL: " + url);
        WechatUser user = restTemplate.getForObject(url, WechatUser.class);
        System.out.println("微信用户信息响应: " + user);
        log.info("微信用户信息响应: " + user);
       return user;
}

    // 内部类用于解析access_token响应
    public static class AccessTokenResponse {
        @SerializedName("access_token")
        private String accessToken;
        private String openid;
        private String refreshToken;
        private long expiresIn;
        private String scope;
        // getter和setter方法
        // 获取accessToken
        public String getAccessToken() {
            return accessToken;
        }
        // 设置accessToken
        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
        // 获取openid
        public String getOpenid() {
            return openid;
        }
        // 设置openid
        public void setOpenid(String openid) {
            this.openid = openid;
        }
    }

    
    
}