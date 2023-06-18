package com.xftxyz.elm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Food;
import com.xftxyz.elm.mapper.FoodMapper;
import com.xftxyz.elm.service.FoodService;

/**
 * @author 25810
 * @description 针对表【food】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
        implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> findFoodByBusinessid(Integer businessid) {
        return foodMapper.selectAllByBusinessid(businessid);
    }

}
