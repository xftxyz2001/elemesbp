package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.domain.Food;
import com.xftxyz.elm.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    /**
     * 根据商家编号查询商家下的食品列表
     * 
     * @param businessid 商家编号
     * @return 食品列表
     */
    @GetMapping("/business/{businessid}")
    public List<Food> findFoodByBusinessid(@PathVariable("businessid") Integer businessid) {
        return foodService.findFoodByBusinessid(businessid);
    }
}
