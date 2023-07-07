package com.xftxyz.elm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Deliveryaddress;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.mapper.DeliveryaddressMapper;
import com.xftxyz.elm.service.DeliveryaddressService;

/**
 * @author 25810
 * @description 针对表【deliveryaddress】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
public class DeliveryaddressServiceImpl extends ServiceImpl<DeliveryaddressMapper, Deliveryaddress>
        implements DeliveryaddressService {

    @Autowired
    private DeliveryaddressMapper deliveryaddressMapper;

    @Override
    public List<Deliveryaddress> listDeliveryAddressByUser(User user) {
        return deliveryaddressMapper.selectAllByUserid(user.getUserid());
    }

    @Override
    public Boolean saveDeliveryAddress(String userid, String contactname, Integer contactsex, String contacttel,
            String address) {
        Deliveryaddress deliveryaddress = new Deliveryaddress();
        deliveryaddress.setUserid(userid);
        deliveryaddress.setContactname(contactname);
        deliveryaddress.setContactsex(contactsex);
        deliveryaddress.setContacttel(contacttel);
        deliveryaddress.setAddress(address);
        return save(deliveryaddress);
    }

}
