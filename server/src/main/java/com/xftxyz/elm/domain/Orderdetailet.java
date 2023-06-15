package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName orderdetailet
 */
@TableName(value ="orderdetailet")
public class Orderdetailet implements Serializable {
    /**
     * 订单明细编号
     */
    @TableId(type = IdType.AUTO)
    private Integer odid;

    /**
     * 所属订单编号
     */
    private Integer orderid;

    /**
     * 食品编号
     */
    private Integer foodid;

    /**
     * 数量
     */
    private Integer quantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 订单明细编号
     */
    public Integer getOdid() {
        return odid;
    }

    /**
     * 订单明细编号
     */
    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    /**
     * 所属订单编号
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 所属订单编号
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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
     * 数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 数量
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
        Orderdetailet other = (Orderdetailet) that;
        return (this.getOdid() == null ? other.getOdid() == null : this.getOdid().equals(other.getOdid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getFoodid() == null ? other.getFoodid() == null : this.getFoodid().equals(other.getFoodid()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOdid() == null) ? 0 : getOdid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getFoodid() == null) ? 0 : getFoodid().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", odid=").append(odid);
        sb.append(", orderid=").append(orderid);
        sb.append(", foodid=").append(foodid);
        sb.append(", quantity=").append(quantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}