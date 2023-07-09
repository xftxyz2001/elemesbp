package com.xftxyz.elm.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xftxyz.elm.domain.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 25810
* @description 针对表【business】的数据库操作Mapper
* @createDate 2023-06-15 16:16:07
* @Entity com.xftxyz.elm.domain.Business
*/
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
    List<Business> selectAllByOrdertypeid(@Param("ordertypeid") Integer ordertypeid);

    List<Business> selectAllByBusinessnameLike(@Param("businessname") String businessname);

    List<Business> selectAllByBusinessaddressLike(@Param("businessaddress") String businessaddress);
}




