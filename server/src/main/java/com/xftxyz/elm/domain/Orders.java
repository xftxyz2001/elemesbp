package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
public class Orders implements Serializable {
    /**
     * 订单编号
     */
    @TableId(type = IdType.AUTO)
    private Integer orderid;

    /**
     * 用户编号
     */
    private String userid;

    /**
     * 商家编号
     */
    private Integer businessid;

    /**
     * 订购日期
     */
    private String orderdate;

    /**
     * 订单总价
     */
    private BigDecimal ordertotal;

    /**
     * 送货地址编号
     */
    private Integer daid;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    private Integer orderstate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 订单编号
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 用户编号
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户编号
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 商家编号
     */
    public Integer getBusinessid() {
        return businessid;
    }

    /**
     * 商家编号
     */
    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    /**
     * 订购日期
     */
    public String getOrderdate() {
        return orderdate;
    }

    /**
     * 订购日期
     */
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    /**
     * 订单总价
     */
    public BigDecimal getOrdertotal() {
        return ordertotal;
    }

    /**
     * 订单总价
     */
    public void setOrdertotal(BigDecimal ordertotal) {
        this.ordertotal = ordertotal;
    }

    /**
     * 送货地址编号
     */
    public Integer getDaid() {
        return daid;
    }

    /**
     * 送货地址编号
     */
    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    public Integer getOrderstate() {
        return orderstate;
    }

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Orders other = (Orders) that;
        return (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getBusinessid() == null ? other.getBusinessid() == null : this.getBusinessid().equals(other.getBusinessid()))
            && (this.getOrderdate() == null ? other.getOrderdate() == null : this.getOrderdate().equals(other.getOrderdate()))
            && (this.getOrdertotal() == null ? other.getOrdertotal() == null : this.getOrdertotal().equals(other.getOrdertotal()))
            && (this.getDaid() == null ? other.getDaid() == null : this.getDaid().equals(other.getDaid()))
            && (this.getOrderstate() == null ? other.getOrderstate() == null : this.getOrderstate().equals(other.getOrderstate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getBusinessid() == null) ? 0 : getBusinessid().hashCode());
        result = prime * result + ((getOrderdate() == null) ? 0 : getOrderdate().hashCode());
        result = prime * result + ((getOrdertotal() == null) ? 0 : getOrdertotal().hashCode());
        result = prime * result + ((getDaid() == null) ? 0 : getDaid().hashCode());
        result = prime * result + ((getOrderstate() == null) ? 0 : getOrderstate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", userid=").append(userid);
        sb.append(", businessid=").append(businessid);
        sb.append(", orderdate=").append(orderdate);
        sb.append(", ordertotal=").append(ordertotal);
        sb.append(", daid=").append(daid);
        sb.append(", orderstate=").append(orderstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}