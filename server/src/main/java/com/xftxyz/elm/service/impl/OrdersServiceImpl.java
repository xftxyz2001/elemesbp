package com.xftxyz.elm.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.domain.Orders;
import com.xftxyz.elm.enums.OrderStatus;
import com.xftxyz.elm.mapper.OrdersMapper;
import com.xftxyz.elm.service.CartService;
import com.xftxyz.elm.service.OrderdetailetService;
import com.xftxyz.elm.service.OrdersService;
import com.xftxyz.elm.utils.DateFormatUtils;
import com.xftxyz.elm.vo.res.CartInfoVO;

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

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderdetailetService orderdetailetService;

    @Override
    public List<Orders> findOrdersByUserId(String userId) {
        return ordersMapper.selectAllByUserid(userId);
    }

    @Override
    public Orders createOrders(String userid, Integer businessid, Integer daid) {
        // 获取购物车
        List<Cart> carts = cartService.listCart(userid, businessid);
        CartInfoVO cartInfo = cartService.getCartInfo(carts);
        BigDecimal totalSettle = cartInfo.getTotalSettle();

        // 创建订单
        Orders orders = new Orders();
        orders.setUserid(userid);
        orders.setBusinessid(businessid);
        orders.setDaid(daid);
        orders.setOrdertotal(totalSettle);
        orders.setOrderdate(DateFormatUtils.currentTime());
        orders.setOrderstate(OrderStatus.UNPAID.getValue());
        ordersMapper.insert(orders);

        // 添加订单明细
        orderdetailetService.saveOrderdetailet(orders.getOrderid(), carts);
        // 清空购物车
        cartService.deleteCart(userid, businessid);
        return orders;

    }

}
