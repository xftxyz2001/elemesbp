package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.xftxyz.elm.validation.ValidInfo;
import com.xftxyz.elm.vo.req.DeliveryaddressVO;

import jakarta.validation.constraints.NotNull;

/**
 * 配送地址相关
 */
@RestController
@RequestMapping("/daddress")
@Validated
public class DeliveryAddressController {

    @Autowired
    private DeliveryaddressService deliveryaddressService;

    /**
     * 列出用户的所有配送地址
     * 
     * @param user 当前用户
     * @return 配送地址列表
     */
    @GetMapping("/list")
    public List<Deliveryaddress> listDeliveryAddressByUserId(@RequestAttribute(ElmProperties.requestUser) User user) {
        return deliveryaddressService.listDeliveryAddressByUser(user);
    }

    /**
     * 根据配送地址编号查询配送地址
     * 
     * @param daid 配送地址编号
     * @return 配送地址
     */
    @GetMapping("/{daid}")
    public Deliveryaddress getDeliveryAddressById(
            @PathVariable("daid") @NotNull(message = ValidInfo.DELIVERY_ADDRESS_ID_NOT_NULL) Integer daid) {
        return deliveryaddressService.getById(daid);
    }

    /**
     * 添加配送地址
     * 
     * @param user              当前用户
     * @param deliveryaddressVO 配送地址信息
     * @return 是否添加成功
     */
    @PostMapping("/save")
    public Boolean saveDeliveryAddress(@RequestAttribute(ElmProperties.requestUser) User user,
            @RequestBody @Validated DeliveryaddressVO deliveryaddressVO) {
        return deliveryaddressService.saveDeliveryAddress(
                deliveryaddressVO.getDaid(),
                user.getUserid(),
                deliveryaddressVO.getContactname(),
                deliveryaddressVO.getContactsex(),
                deliveryaddressVO.getContacttel(),
                deliveryaddressVO.getAddress());
    }

    /**
     * 删除配送地址
     * 
     * @param daid 配送地址编号
     * @return 是否删除成功
     */
    @DeleteMapping("/{daid}")
    public Boolean removeDeliveryAddressById(
            @PathVariable("daid") @NotNull(message = ValidInfo.DELIVERY_ADDRESS_ID_NOT_NULL) Integer daid) {
        return deliveryaddressService.removeById(daid);
    }

}
