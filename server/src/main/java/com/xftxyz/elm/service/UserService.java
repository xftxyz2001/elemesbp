package com.xftxyz.elm.service;

import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.vo.req.LoginVO;
import com.xftxyz.elm.vo.req.RegisterVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 25810
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-06-15 16:16:07
 */
public interface UserService extends IService<User> {

    User login(LoginVO loginVO);

    boolean checkUserid(String userid);

    boolean register(RegisterVO registerVO);

    String toToken(User user);

    User fromToken(String token);

}
