package com.xftxyz.elm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.UserService;

@SpringBootTest
class ElmApplicationTests {

    @Autowired
    UserService userService;
    
    @Test
    void contextLoads() {
        List<User> users = userService.list();
        users.forEach(System.out::println);
    }

}
