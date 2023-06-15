package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName cart
 */
@TableName(value ="cart")
public class Cart implements Serializable {
    /**
     * 无意义编号
     */
    @TableId(type = IdType.AUTO)
    private Integer cartid;

    /**
     * 食品编号
     */
    private Integer foodid;

    /**
     * 所属商家编号
     */
    private Integer businessid;

    /**
     * 所属用户编号
     */
    private String userid;

    /**
     * 同一类型食品的购买数量
     */
    private Integer quantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 无意义编号
     */
    public Integer getCartid() {
        return cartid;
    }

    /**
     * 无意义编号
     */
    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    /**
     * 食品编号
     */
    public Integer getFoodid() {
        return foodid;
    }

    /**
     * 食品编号
     */
    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    /**
     * 所属商家编号
     */
    public Integer getBusinessid() {
        return businessid;
    }

    /**
     * 所属商家编号
     */
    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    /**
     * 所属用户编号
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 所属用户编号
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 同一类型食品的购买数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 同一类型食品的购买数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        Cart other = (Cart) that;
        return (this.getCartid() == null ? other.getCartid() == null : this.getCartid().equals(other.getCartid()))
            && (this.getFoodid() == null ? other.getFoodid() == null : this.getFoodid().equals(other.getFoodid()))
            && (this.getBusinessid() == null ? other.getBusinessid() == null : this.getBusinessid().equals(other.getBusinessid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCartid() == null) ? 0 : getCartid().hashCode());
        result = prime * result + ((getFoodid() == null) ? 0 : getFoodid().hashCode());
        result = prime * result + ((getBusinessid() == null) ? 0 : getBusinessid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cartid=").append(cartid);
        sb.append(", foodid=").append(foodid);
        sb.append(", businessid=").append(businessid);
        sb.append(", userid=").append(userid);
        sb.append(", quantity=").append(quantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}