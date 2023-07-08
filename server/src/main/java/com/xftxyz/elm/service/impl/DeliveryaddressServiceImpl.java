package com.xftxyz.elm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class DeliveryaddressServiceImpl extends ServiceImpl<DeliveryaddressMapper, Deliveryaddress>
        implements DeliveryaddressService {

    @Autowired
    private DeliveryaddressMapper deliveryaddressMapper;

    @Override
    public List<Deliveryaddress> listDeliveryAddressByUser(User user) {
        return deliveryaddressMapper.selectAllByUserid(user.getUserid());
    }

    @Override
    public Boolean saveDeliveryAddress(Integer daid, String userid, String contactname, Integer contactsex,
            String contacttel, String address) {
        // 查询是否存在
        Deliveryaddress deliveryaddress = getById(daid);
        // 存在，更新
        if (deliveryaddress != null) {
            deliveryaddress.setContactname(contactname);
            deliveryaddress.setContactsex(contactsex);
            deliveryaddress.setContacttel(contacttel);
            deliveryaddress.setAddress(address);
            return updateById(deliveryaddress);
        }
        // 不存在，添加
        deliveryaddress = new Deliveryaddress();
        deliveryaddress.setUserid(userid);
        deliveryaddress.setContactname(contactname);
        deliveryaddress.setContactsex(contactsex);
        deliveryaddress.setContacttel(contacttel);
        deliveryaddress.setAddress(address);
        return save(deliveryaddress);
    }

}
