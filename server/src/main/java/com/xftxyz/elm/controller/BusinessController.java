package com.xftxyz.elm.controller;

import com.xftxyz.elm.domain.Business;
import com.xftxyz.elm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
