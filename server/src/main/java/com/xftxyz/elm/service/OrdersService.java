package com.xftxyz.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.elm.domain.Orders;

/**
* @author 25810
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-06-15 16:16:07
*/
public interface OrdersService extends IService<Orders> {

    List<Orders> findOrdersByUserId(String userId);

    Orders createOrders(String userid, Integer businessid, Integer daid);

}
