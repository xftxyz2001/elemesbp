package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.Deliveryaddress;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.DeliveryaddressService;

/**
 * 配送地址相关
 */
@RestController
@RequestMapping("/deliveryaddress")
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
    public Deliveryaddress getDeliveryAddressById(Integer daid) {
        return deliveryaddressService.getById(daid);
    }

    // 添加配送地址
    // public Object saveDeliveryAddress(HttpServletRequest request) throws
    // Exception {
    // String contactName = request.getParameter("contactName");
    // String contactTel = request.getParameter("contactTel");
    // String address = request.getParameter("address");
    // int contactSex = Integer.parseInt(request.getParameter("contactSex"));
    // String userId = request.getParameter("userId");
    // int i = deliveryaddressService.saveDeliveryAddress(contactName, contactSex,
    // contactTel, address, userId);
    // return i;
    // }

    // 修改配送地址
    // public Object updateDeliveryAddress(HttpServletRequest request) throws
    // Exception {
    // String contactName = request.getParameter("contactName");
    // String contactTel = request.getParameter("contactTel");
    // String address = request.getParameter("address");
    // String userId = request.getParameter("userId");
    // int contactSex = Integer.parseInt(request.getParameter("contactSex"));
    // int daId = Integer.parseInt(request.getParameter("daId"));
    // int i = deliveryaddressService.updateDeliveryAddress(daId, contactName,
    // contactSex, contactTel, address,
    // userId);
    // return i;
    // }

    // 删除配送地址
    @DeleteMapping("/{daid}")
    public boolean removeDeliveryAddressById(Integer daid) {
        return deliveryaddressService.removeById(daid);
    }

}
