package com.xftxyz.elm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.elm.config.ElmProperties;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.domain.User;
import com.xftxyz.elm.service.CartService;
import com.xftxyz.elm.validation.ValidInfo;
import com.xftxyz.elm.vo.req.CartUpdateVO;
import com.xftxyz.elm.vo.res.CartInfoVO;
import com.xftxyz.elm.vo.res.CartWithFoodVO;

import jakarta.validation.constraints.NotBlank;

/**
 * 购物车相关
 */
@RestController
@RequestMapping("/cart")
@Validated
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 统计当前用户在指定店家的购物车项数
     * 
     * @param user       当前用户
     * @param businessid 商家编号
     * @return 购物车项数
     */
    @GetMapping("/count/{businessid}")
    public Integer getCartItemCountForUserInStore(@RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") @NotBlank(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.getTotalQuantity(user.getUserid(), businessid);
    }

    /**
     * 当前用户在指定店家的购物车
     * 
     * @param user       当前用户
     * @param businessid 商家编号
     * @return 购物车列表
     */
    @GetMapping("/business/{businessid}")
    public List<Cart> listCart(@RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") @NotBlank(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.listCart(user.getUserid(), businessid);
    }

    /**
     * 当前用户在指定店家的购物车（包含食品信息）
     * 
     * @param user       当前用户
     * @param businessid 商家编号
     * @return 购物车列表（包含食品信息）
     */
    @GetMapping("/business/{businessid}/with/food")
    public List<CartWithFoodVO> listCartWithFood(@RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") @NotBlank(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.listCartWithFood(user.getUserid(), businessid);
    }

    /**
     * 当前用户在指定店家的购物车信息
     * 
     * @param user       当前用户
     * @param businessid 商家编号
     * @return 购物车信息（总价、总数）
     */
    @GetMapping("/info/{businessid}")
    public CartInfoVO getCartInfo(@RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") @NotBlank(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.getCartInfo(user.getUserid(), businessid);
    }

    /**
     * 更新购物车
     * 
     * @param user         当前用户
     * @param cartUpdateVO 购物车更新信息
     * @return 是否更新成功
     */
    @PutMapping("/update")
    public Boolean updateCart(@RequestAttribute(ElmProperties.requestUser) User user,
            @RequestBody @Validated CartUpdateVO cartUpdateVO) {
        return cartService.updateCart(user.getUserid(), cartUpdateVO.getBusinessid(), cartUpdateVO.getFoodid(),
                cartUpdateVO.getQuantity());
    }

}
