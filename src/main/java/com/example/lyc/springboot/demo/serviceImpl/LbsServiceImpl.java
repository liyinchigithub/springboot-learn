package com.example.lyc.springboot.demo.serviceImpl;

import com.example.lyc.springboot.demo.entity.LbsInfo;
import com.example.lyc.springboot.demo.mapper.LbsMapper;
import com.example.lyc.springboot.demo.service.LbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LbsServiceImpl implements LbsService {
    @Autowired
    private LbsMapper lbsMapper;

    @Override
    public void saveLocationInfo(LbsInfo lbsInfo) {
        lbsMapper.insertLbsInfo(lbsInfo);
    }
}