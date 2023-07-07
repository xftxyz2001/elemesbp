package com.xftxyz.elm.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xftxyz.elm.domain.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25810
* @description 针对表【cart】的数据库操作Mapper
* @createDate 2023-06-15 16:16:07
* @Entity com.xftxyz.elm.domain.Cart
*/
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    int countByUseridAndBusinessid(@Param("userid") String userid, @Param("businessid") Integer businessid);

    List<Cart> selectByUseridAndBusinessid(@Param("userid") String userid, @Param("businessid") Integer businessid);

    Cart selectOneByUseridAndBusinessidAndFoodid(@Param("userid") String userid, @Param("businessid") Integer businessid, @Param("foodid") Integer foodid);
}




