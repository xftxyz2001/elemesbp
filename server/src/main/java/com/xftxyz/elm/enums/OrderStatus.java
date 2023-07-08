package com.xftxyz.elm.enums;

public enum OrderStatus {
    // 0：未支付 1：已支付
    UNPAID(0, "未支付"), PAID(1, "已支付");

    private int value;

    private String desc;

    private OrderStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
