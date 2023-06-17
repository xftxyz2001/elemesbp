package com.xftxyz.elm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.service.DeliveryaddressService;

@RestController
public class DeliveryAddressController {

    @Autowired
    private DeliveryaddressService deliveryaddressService;

    // public Object listDeliveryAddressByUserId(HttpServletRequest request) throws Exception {
    //     String userId = request.getParameter("userId");
    //     List<Deliveryaddress> deliveryaddresses = deliveryaddressService.listDeliveryAddressByUserId(userId);
    //     return deliveryaddresses;
    // }

    // public Object getDeliveryAddressById(HttpServletRequest request) throws Exception {
    //     int daId = Integer.parseInt(request.getParameter("daId"));
    //     Deliveryaddress deliveryAddressById = deliveryaddressService.getDeliveryAddressById(daId);
    //     return deliveryAddressById;
    // }

    // public Object saveDeliveryAddress(HttpServletRequest request) throws Exception {
    //     String contactName = request.getParameter("contactName");
    //     String contactTel = request.getParameter("contactTel");
    //     String address = request.getParameter("address");
    //     int contactSex = Integer.parseInt(request.getParameter("contactSex"));
    //     String userId = request.getParameter("userId");
    //     int i = deliveryaddressService.saveDeliveryAddress(contactName, contactSex, contactTel, address, userId);
    //     return i;
    // }

    // public Object updateDeliveryAddress(HttpServletRequest request) throws Exception {
    //     String contactName = request.getParameter("contactName");
    //     String contactTel = request.getParameter("contactTel");
    //     String address = request.getParameter("address");
    //     String userId = request.getParameter("userId");
    //     int contactSex = Integer.parseInt(request.getParameter("contactSex"));
    //     int daId = Integer.parseInt(request.getParameter("daId"));
    //     int i = deliveryaddressService.updateDeliveryAddress(daId, contactName, contactSex, contactTel, address,
    //             userId);
    //     return i;
    // }

    // public Object removeDeliveryAddress(HttpServletRequest request) throws Exception {
    //     int daId = Integer.parseInt(request.getParameter("daId"));
    //     int i = deliveryaddressService.removeDeliveryAddress(daId);
    //     return i;
    // }
}
