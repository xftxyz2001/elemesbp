package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.domain.Orders;
import com.xftxyz.elm.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 根据用户编号查询订单
     * 
     * @param userId 用户编号
     * @return 订单列表
     */
    @GetMapping("/user/{userid}")
    public List<Orders> findOrdersByUserId(@PathVariable("userid") String userId) {
        return ordersService.findOrdersByUserId(userId);
    }

    /**
     * 根据订单编号查询订单
     * 
     * @param orderId 订单编号
     * @return 订单
     */
    @GetMapping("/{orderid}")
    public Orders findOrdersById(@PathVariable("orderid") int orderId) {
        return ordersService.getById(orderId);
    }

    // 创建订单
    // public Object createOrders(HttpServletRequest request) {
    // String userId = request.getParameter("userId");
    // int businessId = Integer.parseInt(request.getParameter("businessId"));
    // int daId = Integer.parseInt(request.getParameter("daId"));
    // int orders = ordersService.createOrders(userId, businessId, daId);
    // return orders;
    // }

    // 取消订单
    // 支付订单

}
