package com.example.lyc.springboot.demo.mapper;

import com.example.lyc.springboot.demo.entity.LbsInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LbsMapper {
    void insertLbsInfo(LbsInfo lbsInfo);
}