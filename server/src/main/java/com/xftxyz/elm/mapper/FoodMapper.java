package com.xftxyz.elm.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xftxyz.elm.domain.Food;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25810
* @description 针对表【food】的数据库操作Mapper
* @createDate 2023-06-15 16:16:07
* @Entity com.xftxyz.elm.domain.Food
*/
@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    List<Food> selectAllByBusinessid(@Param("businessid") Integer businessid);
}




