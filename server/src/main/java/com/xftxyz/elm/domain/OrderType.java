package com.xftxyz.elm.domain;

/*
 * 点餐分类
 */
public enum OrderType {
    FOOD(1, "美食"),
    BREAKFAST(2, "早餐"),
    ERRAND(3, "跑腿代购"),
    BURGER_PIZZA(4, "汉堡披萨"),
    DESSERT_DRINK(5, "甜品饮品"),
    FAST_FOOD(6, "速食简餐"),
    LOCAL_SNACK(7, "地方小吃"),
    RICE_NOODLE(8, "米粉面馆"),
    STEAMED_BUN_CONGEE(9, "包子粥铺"),
    FRIED_CHICKEN_SKWER(10, "炸鸡炸串");

    private final int value;
    private final String name;

    OrderType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
