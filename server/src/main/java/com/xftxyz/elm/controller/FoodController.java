package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.Food;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.FoodService;
import com.xftxyz.elm.vo.res.FoodWithQuantityVO;

/**
 * 食品相关
 */
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
    public List<Food> getFoodList(@PathVariable("businessid") Integer businessid) {
        return foodService.getFoodList(businessid);
    }

    /**
     * 根据商家编号查询商家下的食品列表（包括购物车）
     * 
     * @param businessid 商家编号
     * @return 食品列表
     */
    @GetMapping("/business/{businessid}/with/quantity")
    public List<FoodWithQuantityVO> getFoodListWithQuantity(
            @RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") Integer businessid) {
        return foodService.getFoodListWithQuantity(businessid);
    }
}
