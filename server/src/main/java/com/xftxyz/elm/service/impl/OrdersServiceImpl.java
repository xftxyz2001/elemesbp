package com.xftxyz.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Orders;
import com.xftxyz.elm.service.OrdersService;
import com.xftxyz.elm.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-06-15 16:16:07
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




