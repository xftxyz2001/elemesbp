package com.xftxyz.elm.mapper;
import org.apache.ibatis.annotations.Param;

import com.xftxyz.elm.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25810
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-15 16:16:07
* @Entity com.xftxyz.elm.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectOneByUseridAndPassword(@Param("userid") String userid, @Param("password") String password);
}




