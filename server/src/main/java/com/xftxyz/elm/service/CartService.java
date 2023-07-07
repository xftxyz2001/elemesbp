package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.vo.res.CartInfoVO;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 25810
 * @description 针对表【cart】的数据库操作Service
 * @createDate 2023-06-15 16:16:07
 */
public interface CartService extends IService<Cart> {

    // Integer getCartItemCountForUserInStore(String userid, Integer businessid);

    List<Cart> listCart(String userid, Integer businessid);

    Integer getTotalQuantity(String userid, Integer businessid);

    Integer getTotalQuantity(List<Cart> carts);
    
    CartInfoVO getCartInfo(String userid, Integer businessid);

}
