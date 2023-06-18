package com.xftxyz.elm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Orders;
import com.xftxyz.elm.mapper.OrdersMapper;
import com.xftxyz.elm.service.OrdersService;

/**
 * @author 25810
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findOrdersByUserId(String userId) {
        return ordersMapper.selectAllByUserid(userId);
    }

    /*
     * // 创建订单
     * // 开启事务
     * //1、查询当前用户购物车中当前商家的所有食品
     * CartDaoImpl cartDao = new CartDaoImpl();
     * List<Cart> carts = cartDao.listCart(userId, businessId);
     * //2、查询商家信息（需要使用商家的配送费信息）
     * BusinessDaoImpl businessDao = new BusinessDaoImpl();
     * Business business = businessDao.getBusinessById(businessId);
     * //3、获取订单总额
     * for (Cart cart : carts) {
     * orderTotal += cart.getFood().getFoodPrice() * cart.getQuantity();
     * }
     * //加上配送费
     * orderTotal += business.getDeliveryPrice();
     * //3、创建订单，并获取订单编号
     * OrdersDaoImpl ordersDao = new OrdersDaoImpl();
     * orderId = ordersDao.createOrders(userId, businessId, daId, orderTotal);
     * //4、处理相关数据：获取订单明细集合
     * OrderdetailetDaoImpl orderdetailetDao = new OrderdetailetDaoImpl();
     * //5、批量添加订单明细
     * for (Cart cart : carts) {
     * orderdetailetDao.saveOrderdetailet(cart.getFoodId(), orderId,
     * cart.getQuantity());
     * }
     * //6、清空当前用户购物车中当前商家的所有食品
     * cartDao.removeCart1(userId, businessId);
     * //提交事务
     */
}
