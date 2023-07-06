package com.xftxyz.elm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.mapper.CartMapper;
import com.xftxyz.elm.service.CartService;

/**
 * @author 25810
 * @description 针对表【cart】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
        implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Integer getCartItemCountForUserInStore(String userid, Integer businessid) {
        return cartMapper.countByUseridAndBusinessid(userid, businessid);
    }

}
