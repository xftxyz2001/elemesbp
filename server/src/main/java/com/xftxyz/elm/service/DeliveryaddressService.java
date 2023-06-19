package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.Deliveryaddress;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 25810
* @description 针对表【deliveryaddress】的数据库操作Service
* @createDate 2023-06-15 16:16:07
*/
public interface DeliveryaddressService extends IService<Deliveryaddress> {

    List<Deliveryaddress> listDeliveryAddressByUserId(String userid);

}
