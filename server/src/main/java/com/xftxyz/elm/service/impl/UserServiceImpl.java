package com.xftxyz.elm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.mapper.UserMapper;
import com.xftxyz.elm.service.UserService;

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
    public Boolean checkUserid(String userid) {
        return userMapper.countByUserid(userid) > 0;
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
        return login(userid, password);
    }

    @Override
    public User login(String userid, String password) {
        return userMapper.selectOneByUseridAndPassword(userid, password);
    }

    @Override
    public Boolean register(String userid, String password, String username, Integer usersex) {
        if (checkUserid(userid)) {
            return false;
        }
        User user = new User();
        user.setUserid(userid);
        user.setPassword(password);
        user.setUsername(username);
        user.setUsersex(usersex);
        return save(user);
    }

}
