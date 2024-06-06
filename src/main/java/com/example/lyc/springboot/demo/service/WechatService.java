package com.example.lyc.springboot.demo.service;

import com.example.lyc.springboot.demo.entity.WechatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
// 微信服务类
@Service
public class WechatService {
    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.redirect.uri}")
    private String redirectUri; // 添加这行


    @Autowired
    private RestTemplate restTemplate;

    // 实现根据code获取access_token的逻辑
    // 实现根据access_token获取用户信息的逻辑

    // 通用方法获取access_token
    public AccessTokenResponse getAccessToken(String code, String grantType) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("appid", appId)
            .queryParam("secret", secret)
            .queryParam("code", code)
            .queryParam("grant_type", grantType); // "authorization_code" for H5, "client_credential" for APP
    
        return restTemplate.getForObject(builder.toUriString(), AccessTokenResponse.class);
    }

    // 获取用户信息
    public WechatUser getUserInfo(String accessToken,String openid) {
        String url = "https://api.weixin.qq.com/sns/userinfo";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("access_token", accessToken)
            .queryParam("openid", openid) // 这里的OPENID应从access_token响应中获取
            .queryParam("lang", "zh_CN");

        return restTemplate.getForObject(builder.toUriString(), WechatUser.class);
    }

    // 内部类用于解析access_token响应
    public static class AccessTokenResponse {
        private String accessToken; // 访问令牌
        private String openid; // 微信用户ID

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