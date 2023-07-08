package com.xftxyz.elm.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xftxyz.elm.domain.Business;
import com.xftxyz.elm.domain.Cart;
import com.xftxyz.elm.domain.Food;
import com.xftxyz.elm.mapper.CartMapper;
import com.xftxyz.elm.service.BusinessService;
import com.xftxyz.elm.service.CartService;
import com.xftxyz.elm.service.FoodService;
import com.xftxyz.elm.vo.res.CartInfoVO;
import com.xftxyz.elm.vo.res.CartWithFoodVO;

/**
 * @author 25810
 * @description 针对表【cart】的数据库操作Service实现
 * @createDate 2023-06-15 16:16:07
 */
@Service
@Transactional
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
        implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private FoodService foodService;

    @Autowired
    private BusinessService businessService;

    // @Override
    // public Integer getCartItemCountForUserInStore(String userid, Integer
    // businessid) {
    // return cartMapper.countByUseridAndBusinessid(userid, businessid);
    // }

    @Override
    public List<Cart> listCart(String userid, Integer businessid) {
        return cartMapper.selectByUseridAndBusinessid(userid, businessid);
    }

    @Override
    public CartInfoVO getCartInfo(List<Cart> carts) {
        CartInfoVO cartInfoVO = new CartInfoVO();
        // 如果购物车为空
        if (carts.size() == 0) {
            return cartInfoVO;
        }
        for (Cart cart : carts) {
            // 加数量
            cartInfoVO.setTotalQuantity(cartInfoVO.getTotalQuantity() + cart.getQuantity());
            // 加金额
            Food food = foodService.getById(cart.getFoodid());
            cartInfoVO.setTotalPrice(
                    cartInfoVO.getTotalPrice().add(
                            food.getFoodprice().multiply(
                                    BigDecimal.valueOf(cart.getQuantity()))));
        }
        // 查配送费
        Integer businessid = carts.get(0).getBusinessid();
        Business business = businessService.getById(businessid);
        // 总金额
        cartInfoVO.setTotalSettle(cartInfoVO.getTotalPrice().add(business.getDeliveryprice()));
        return cartInfoVO;
    }

    @Override
    public CartInfoVO getCartInfo(String userid, Integer businessid) {
        List<Cart> carts = listCart(userid, businessid);
        return getCartInfo(carts);
    }

    @Override
    public Integer getTotalQuantity(String userid, Integer businessid) {
        List<Cart> carts = listCart(userid, businessid);
        return getTotalQuantity(carts);
    }

    @Override
    public Integer getTotalQuantity(List<Cart> carts) {
        Integer totalQuantity = 0;
        for (Cart cart : carts) {
            totalQuantity += cart.getQuantity();
        }
        return totalQuantity;
    }

    @Override
    public Boolean updateCart(String userid, Integer businessid, Integer foodid, Integer quantity) {
        // 查询出购物车中是否有该商品
        Cart cart = cartMapper.selectOneByUseridAndBusinessidAndFoodid(userid, businessid, foodid);
        if (cart == null) {
            // 没有该商品，新增
            cart = new Cart();
            cart.setUserid(userid);
            cart.setBusinessid(businessid);
            cart.setFoodid(foodid);
            cart.setQuantity(quantity);
            // System.out.println(cart);
            return cartMapper.insert(cart) > 0;
        } else {
            // 有该商品
            if (quantity == 0) {
                // 数量为0，删除
                return cartMapper.deleteById(cart.getCartid()) > 0;
            }
            // 数量不为0，更新
            cart.setQuantity(quantity);
            return cartMapper.updateById(cart) > 0;
        }
    }

    @Override
    public Integer getQuantity(String userid, Integer businessid, Integer foodid) {
        Cart cart = cartMapper.selectOneByUseridAndBusinessidAndFoodid(userid, businessid, foodid);
        if (cart == null) {
            return 0;
        }
        return cart.getQuantity();
    }

    @Override
    public List<CartWithFoodVO> listCartWithFood(String userid, Integer businessid) {
        List<Cart> carts = listCart(userid, businessid);
        List<CartWithFoodVO> cartWithFoodVOs = new ArrayList<>();
        for (Cart cart : carts) {
            CartWithFoodVO cartWithFoodVO = new CartWithFoodVO();
            cartWithFoodVO.setCartid(cart.getCartid());
            cartWithFoodVO.setFoodid(cart.getFoodid());
            cartWithFoodVO.setBusinessid(cart.getBusinessid());
            cartWithFoodVO.setUserid(cart.getUserid());
            cartWithFoodVO.setQuantity(cart.getQuantity());
            cartWithFoodVO.setFood(foodService.getById(cart.getFoodid()));
            cartWithFoodVOs.add(cartWithFoodVO);
        }
        return cartWithFoodVOs;
    }

    @Override
    public Boolean deleteCart(String userid, Integer businessid) {
        return cartMapper.deleteByUseridAndBusinessid(userid, businessid) > 0;
    }

}
