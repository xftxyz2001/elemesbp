package com.xftxyz.elm;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Text;

import com.xftxyz.elm.domain.Deliveryaddress;
import com.xftxyz.elm.service.DeliveryaddressService;
import com.xftxyz.elm.service.UserService;
import com.xftxyz.elm.utils.Text2Img;

@SpringBootTest
class ElmApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    DeliveryaddressService deliveryaddressService;
    
    @Test
    void contextLoads() {
        BufferedImage createImage = Text2Img.createImage("A", "Arial", 48);
        String imageToBase64 = Text2Img.imageToBase64(createImage);
        System.out.println(imageToBase64);
    }

}
