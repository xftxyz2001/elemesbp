package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 25810
 * @description 针对表【cart】的数据库操作Service
 * @createDate 2023-06-15 16:16:07
 */
public interface CartService extends IService<Cart> {

    Integer getCartItemCountForUserInStore(String userid, Integer businessid);

}
