package com.xftxyz.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.service.CartService;
import com.xftxyz.elm.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2023-06-15 16:16:07
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




