package com.xftxyz.elm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Food;
import com.xftxyz.elm.service.FoodService;
import com.xftxyz.elm.mapper.FoodMapper;
import org.springframework.stereotype.Service;

/**
* @author 25810
* @description 针对表【food】的数据库操作Service实现
* @createDate 2023-06-15 16:16:07
*/
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
    implements FoodService{

}



