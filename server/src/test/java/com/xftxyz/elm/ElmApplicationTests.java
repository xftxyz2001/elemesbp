package com.xftxyz.elm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xftxyz.elm.domain.Deliveryaddress;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.DeliveryaddressService;
import com.xftxyz.elm.service.UserService;

@SpringBootTest
class ElmApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    DeliveryaddressService deliveryaddressService;
    
    @Test
    void contextLoads() {
        Deliveryaddress byId = deliveryaddressService.getById(1);
        System.out.println(byId);
    }

}
