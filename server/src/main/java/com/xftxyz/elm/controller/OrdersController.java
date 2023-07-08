package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.Orders;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.OrdersService;
import com.xftxyz.elm.vo.req.OrdersNewVO;
import com.xftxyz.elm.vo.res.OrdersVO;

/**
 * 订单相关
 */
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

    /**
     * 根据订单编号查询订单详细信息
     * 
     * @param orderId 订单编号
     * @return 订单详细信息
     */
    @GetMapping("/detailet/{orderid}")
    public OrdersVO findOrderdetailetById(@PathVariable("orderid") int orderId) {
        return ordersService.getDetailetById(orderId);
    }

    /**
     * 创建订单
     * 
     * @param user        用户
     * @param ordersNewVO 订单信息
     * @return 订单
     */
    @PostMapping("/new")
    public Orders createOrders(@RequestAttribute(ElmProperties.requestUser) User user,
            @RequestBody OrdersNewVO ordersNewVO) {
        return ordersService.createOrders(user.getUserid(), ordersNewVO.getBusinessid(),
                ordersNewVO.getDaid());
    }

    // 取消订单
    // 支付订单

}
