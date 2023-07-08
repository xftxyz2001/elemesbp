package com.xftxyz.elm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.domain.Orderdetailet;
import com.xftxyz.elm.mapper.OrderdetailetMapper;
import com.xftxyz.elm.service.OrderdetailetService;

/**
 * @author 25810
 * @description 针对表【orderdetailet】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
@Transactional
public class OrderdetailetServiceImpl extends ServiceImpl<OrderdetailetMapper, Orderdetailet>
        implements OrderdetailetService {

    @Autowired
    private OrderdetailetMapper orderdetailetMapper;
            
    @Override
    public Boolean saveOrderdetailet(Integer orderid, List<Cart> carts) {
        List<Orderdetailet> orderdetailets = new ArrayList<>();
        
        for (Cart cart : carts) {
            Orderdetailet orderdetailet = new Orderdetailet();
            orderdetailet.setOrderid(orderid);
            orderdetailet.setFoodid(cart.getFoodid());
            orderdetailet.setQuantity(cart.getQuantity());
            orderdetailets.add(orderdetailet);
        }
        return saveBatch(orderdetailets);
    }

    @Override
    public List<Orderdetailet> listOrderdetailet(Integer orderid) {
        return orderdetailetMapper.selectAllByOrderid(orderid);
    }

}
