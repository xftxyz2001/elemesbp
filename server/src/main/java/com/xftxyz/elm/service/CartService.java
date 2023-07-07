package com.xftxyz.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.vo.res.CartInfoVO;

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

    Integer getQuantity(String userid, Integer businessid, Integer foodid);
    
    CartInfoVO getCartInfo(String userid, Integer businessid);

    Boolean updateCart(String userid, Integer businessid, Integer foodid, Integer quantity);

}
