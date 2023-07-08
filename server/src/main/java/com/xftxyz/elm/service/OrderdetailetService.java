package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.domain.Orderdetailet;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25810
* @description 针对表【orderdetailet】的数据库操作Service
* @createDate 2023-06-15 16:16:07
*/
public interface OrderdetailetService extends IService<Orderdetailet> {

    Boolean saveOrderdetailet(Integer orderid, List<Cart> carts);

}
