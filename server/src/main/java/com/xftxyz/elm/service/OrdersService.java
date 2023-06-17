package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.Orders;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25810
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-06-15 16:16:07
*/
public interface OrdersService extends IService<Orders> {

    List<Orders> findOrdersByUserId(String userId);

}
