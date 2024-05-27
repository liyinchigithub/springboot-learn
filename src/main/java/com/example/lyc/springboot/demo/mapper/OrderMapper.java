package com.example.lyc.springboot.demo.mapper;

import com.example.lyc.springboot.demo.entity.Order;

import java.util.List;

/**
 * 定义接口（即"数据库访问对象"）
 * 层级：接口层
 * 通常来说，接口中的方法与数据库中的表字段一一对应
 * 接口中定义的方法，需要与Mapper.xml中的SQL语句相对应
 *
 * */
public interface OrderMapper {
    List<Order> findAllOrders(); // 返回 list对象

    Order findOrderById(int id);// 返回 类对象

    int insertOrder(Order order);

    int updateOrder(Order order);

    int deleteOrder(int id);
    // 分页查询
    List<Order> getAllOrders(int offset, int limit, String sortField);
}
