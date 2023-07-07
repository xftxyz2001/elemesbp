package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.Deliveryaddress;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.DeliveryaddressService;
import com.xftxyz.elm.vo.req.DeliveryaddressVO;

/**
 * 配送地址相关
 */
@RestController
@RequestMapping("/daddress")
public class DeliveryAddressController {

    @Autowired
    private DeliveryaddressService deliveryaddressService;

    // 列出用户的所有配送地址
    @GetMapping("/list")
    public List<Deliveryaddress> listDeliveryAddressByUserId(@RequestAttribute(ElmProperties.requestUser) User user) {
        return deliveryaddressService.listDeliveryAddressByUser(user);
    }

    // 根据配送地址编号查询配送地址
    @GetMapping("/{daid}")
    public Deliveryaddress getDeliveryAddressById(@PathVariable("daid") Integer daid) {
        System.out.println(daid);
        return deliveryaddressService.getById(daid);
    }

    // 添加配送地址
    @PostMapping("/save")
    public Boolean saveDeliveryAddress(@RequestAttribute(ElmProperties.requestUser) User user,
            @RequestBody DeliveryaddressVO deliveryaddressVO) {
        return deliveryaddressService.saveDeliveryAddress(
                deliveryaddressVO.getDaid(),
                user.getUserid(),
                deliveryaddressVO.getContactname(),
                deliveryaddressVO.getContactsex(),
                deliveryaddressVO.getContacttel(),
                deliveryaddressVO.getAddress());
    }

    // 删除配送地址
    @DeleteMapping("/{daid}")
    public boolean removeDeliveryAddressById(@PathVariable("daid") Integer daid) {
        return deliveryaddressService.removeById(daid);
    }

}
