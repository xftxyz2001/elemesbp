package com.xftxyz.elm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xftxyz.elm.domain.User;

/**
 * @author 25810
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-06-15 16:16:07
 */
public interface UserService extends IService<User> {

    User login(String userid, String password);

    Boolean checkUserid(String userid);

    Boolean register(String userid, String password, String username, Integer usersex);

    String toToken(User user);

    User fromToken(String token);

}
