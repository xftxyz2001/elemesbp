package com.xftxyz.elm.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xftxyz.elm.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25810
* @description 针对表【orders】的数据库操作Mapper
* @createDate 2023-06-15 16:16:07
* @Entity com.xftxyz.elm.domain.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    List<Orders> selectAllByUserid(@Param("userid") String userid);
}




