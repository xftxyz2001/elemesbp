package com.xftxyz.elm.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xftxyz.elm.domain.Orderdetailet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25810
* @description 针对表【orderdetailet】的数据库操作Mapper
* @createDate 2023-06-15 16:16:07
* @Entity com.xftxyz.elm.domain.Orderdetailet
*/
@Mapper
public interface OrderdetailetMapper extends BaseMapper<Orderdetailet> {
    List<Orderdetailet> selectAllByOrderid(@Param("orderid") Integer orderid);
}




