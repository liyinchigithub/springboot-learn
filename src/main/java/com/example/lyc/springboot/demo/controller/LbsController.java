package com.example.lyc.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.lyc.springboot.demo.entity.LbsInfo;
import com.example.lyc.springboot.demo.service.LbsService;

@RestController
public class LbsController {
    @Autowired
    private LbsService lbsService;

    @PostMapping("/location")
    public void saveUserLocation(@RequestBody LbsInfo lbsInfo) {
        lbsService.saveLocationInfo(lbsInfo);
    }
}