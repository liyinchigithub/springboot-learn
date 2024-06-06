package com.example.lyc.springboot.demo.entity;

public class WechatUser {
    private String openId; // 用户的唯一标识
    private String nickname; // 用户昵称
    private String gender; // 用户的性别，值为1时是男性，值为2时是女性
    private String city; // 城市
    private String country; // 国家
    private String province; // 省份
    private String avatarUrl; // 用户头像

    // Getters and Setters
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}