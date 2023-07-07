package com.xftxyz.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.elm.domain.Food;
import com.xftxyz.elm.vo.res.FoodWithQuantityVO;

/**
* @author 25810
* @description 针对表【food】的数据库操作Service
* @createDate 2023-06-15 16:16:07
*/
public interface FoodService extends IService<Food> {

    List<Food> getFoodList(Integer businessid);

    List<FoodWithQuantityVO> getFoodListWithQuantity(String userid, Integer businessid);

}
