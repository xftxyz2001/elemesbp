package com.xftxyz.elm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.CartService;

/**
 * 购物车相关
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // 当前用户在指定店家的购物车项数
    @GetMapping("/count/{businessid}}")
    public Integer getCartItemCountForUserInStore(@ModelAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") Integer businessid) {
        return cartService.getCartItemCountForUserInStore(user.getUserid(), businessid);
    }

    // public Object listCart(HttpServletRequest request) throws Exception {
    // String userId = request.getParameter("userId");
    // Integer businessId = Integer.valueOf(request.getParameter("businessId"));
    // List<Cart> carts = cartService.listCart(userId, businessId);
    // return carts;
    // }

    // public Object updateCart(HttpServletRequest request) throws Exception {
    // String userId = request.getParameter("userId");
    // int businessId = Integer.parseInt(request.getParameter("businessId"));
    // int foodId = Integer.parseInt(request.getParameter("foodId"));
    // int quantity = Integer.parseInt(request.getParameter("quantity"));
    // int i = cartService.updateCart(userId, businessId, foodId, quantity);
    // return i;
    // }

    // public Object removeCart(HttpServletRequest request) throws Exception {
    // String userId = request.getParameter("userId");
    // int businessId = Integer.parseInt(request.getParameter("businessId"));
    // int foodId = Integer.parseInt(request.getParameter("foodId"));
    // int i = cartService.removeCart(userId, businessId, foodId);
    // return i;
    // }

    // public Object removeCart1(HttpServletRequest request) throws Exception {
    // String userId = request.getParameter("userId");
    // int businessId = Integer.parseInt(request.getParameter("businessId"));
    // int i = cartService.removeCart1(userId, businessId);
    // return i;
    // }

    // public Object saveCart(HttpServletRequest request) throws Exception {
    // String userId = request.getParameter("userId");
    // int businessId = Integer.parseInt(request.getParameter("businessId"));
    // int foodId = Integer.parseInt(request.getParameter("foodId"));
    // int i = cartService.saveCart(userId, businessId, foodId);
    // return i;
    // }
}
