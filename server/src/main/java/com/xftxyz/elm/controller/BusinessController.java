package com.xftxyz.elm.controller;

import com.xftxyz.elm.domain.Business;
import com.xftxyz.elm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商家相关
 */
@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 根据商家编号查询商家信息
     * 
     * @param businessid 商家编号
     * @return 商家信息
     */
    @GetMapping("/business/{businessid}")
    public Business findBusinessByBusinessid(@PathVariable("businessid") Integer businessid) {
        return businessService.getById(businessid);
    }

    /**
     * 根据点餐分类查询商家信息
     * 
     * @param ordertypeid 点餐分类编号
     * @return 商家信息列表
     */
    @GetMapping("/ordertype/{ordertypeid}")
    public List<Business> findBusinessByOrdertypeid(@PathVariable("ordertypeid") Integer ordertypeid) {
        return businessService.findBusinessByOrdertypeid(ordertypeid);
    }

    // 商家名称
    // 商家地址
    // 起送费
    // 配送费
    /**
     * 根据商家名称查询商家信息
     * 
     * @param businessname 商家名称
     * @return 商家信息列表
     */
    // @GetMapping("/businessname/{businessname}")
    // public List<Business>
    // findBusinessByBusinessname(@PathVariable("businessname") String businessname)
    // {
    // return businessService.findBusinessByBusinessname(businessname);
    // }

    /**
     * 根据商家地址查询商家信息
     * 
     * @param businessaddress 商家地址
     * @return 商家信息列表
     */
    // @GetMapping("/businessaddress/{businessaddress}")
    // public List<Business>
    // findBusinessByBusinessaddress(@PathVariable("businessaddress") String
    // businessaddress) {
    // return businessService.findBusinessByBusinessaddress(businessaddress);
    // }

    /**
     * 根据起送费范围查询商家信息
     * 
     * @param from 起送费下限
     * @param to   起送费上限
     * @return 商家信息列表
     */
    // @GetMapping("/startprice/{from}/{to}")
    // public List<Business>
    // findBusinessByStartpriceRange(@PathVariable("startprice") Integer from,
    // @PathVariable("endprice") Integer to) {
    // return businessService.findBusinessByStartpriceRange(from, to);
    // }

    /**
     * 根据配送费范围查询商家信息
     * 
     * @param from 配送费下限
     * @param to   配送费上限
     * @return 商家信息列表
     */
    // @GetMapping("/deliveryprice/{from}/{to}")
    // public List<Business>
    // findBusinessByDeliverypriceRange(@PathVariable("deliveryprice") Integer from,
    // @PathVariable("deliveryprice") Integer to) {
    // return businessService.findBusinessByDeliverypriceRange(from, to);
    // }

}
