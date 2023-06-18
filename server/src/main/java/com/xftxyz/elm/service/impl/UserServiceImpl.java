package com.xftxyz.elm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.mapper.UserMapper;
import com.xftxyz.elm.service.UserService;
import com.xftxyz.elm.vo.req.LoginVO;
import com.xftxyz.elm.vo.req.RegisterVO;

/**
 * @author 25810
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginVO loginVO) {
        String userid = loginVO.getUserid();
        String password = loginVO.getPassword();
        return userMapper.selectOneByUseridAndPassword(userid, password);
    }

    @Override
    public boolean checkUserid(String userid) {
        return userMapper.countByUserid(userid) > 0;
    }

    @Override
    public boolean register(RegisterVO registerVO) {
        if (checkUserid(registerVO.getUserid())) {
            return false;
        }
        User user = new User();
        user.setUserid(registerVO.getUserid());
        user.setPassword(registerVO.getPassword());
        user.setUsername(registerVO.getUsername());
        user.setUsersex(registerVO.getUsersex());
        return save(user);
    }

    @Override
    public String toToken(User user) {
        return user.getUserid() + ":" + user.getPassword();
    }

    @Override
    public User fromToken(String token) {
        String[] split = token.split(":");
        String userid = split[0];
        String password = split[1];
        return userMapper.selectOneByUseridAndPassword(userid, password);
    }

}
