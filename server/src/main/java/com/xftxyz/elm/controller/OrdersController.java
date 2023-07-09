package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.xftxyz.elm.validation.ValidInfo;
import com.xftxyz.elm.vo.req.OrdersNewVO;
import com.xftxyz.elm.vo.res.OrdersVO;

import jakarta.validation.constraints.NotBlank;

/**
 * 订单相关
 */
@RestController
@RequestMapping("/orders")
@Validated
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
    public List<Orders> findOrdersByUserId(
            @PathVariable("userid") @NotBlank(message = ValidInfo.USER_ID_NOT_NULL) String userId) {
        return ordersService.findOrdersByUserId(userId);
    }

    /**
     * 获取当前用户的订单
     * 
     * @param user 当前用户
     * @return 订单列表
     */
    @GetMapping("/list")
    public List<Orders> findOrdersByUserId(@RequestAttribute(ElmProperties.requestUser) User user) {
        return ordersService.findOrdersByUserId(user.getUserid());
    }

    /**
     * 根据订单编号查询订单
     * 
     * @param orderId 订单编号
     * @return 订单
     */
    @GetMapping("/{orderid}")
    public Orders findOrdersById(
            @PathVariable("orderid") @NotBlank(message = ValidInfo.ORDER_ID_NOT_NULL) Integer orderId) {
        return ordersService.getById(orderId);
    }

    /**
     * 根据订单编号查询订单详细信息
     * 
     * @param orderId 订单编号
     * @return 订单详细信息
     */
    @GetMapping("/detailet/{orderid}")
    public OrdersVO findOrderdetailetById(
            @PathVariable("orderid") @NotBlank(message = ValidInfo.ORDER_ID_NOT_NULL) Integer orderId) {
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
            @RequestBody @Validated OrdersNewVO ordersNewVO) {
        return ordersService.createOrders(user.getUserid(), ordersNewVO.getBusinessid(),
                ordersNewVO.getDaid());
    }

    // 取消订单
    // 支付订单
    @PostMapping("/pay/{orderid}")
    public Boolean payOrder(@RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("orderid") @NotBlank(message = ValidInfo.ORDER_ID_NOT_NULL) Integer orderId) {
        return ordersService.payOrder(user.getUserid(), orderId);
    }

}
