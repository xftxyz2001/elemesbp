package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName food
 */
@TableName(value ="food")
public class Food implements Serializable {
    /**
     * 食品编号
     */
    @TableId(type = IdType.AUTO)
    private Integer foodid;

    /**
     * 食品名称
     */
    private String foodname;

    /**
     * 食品介绍
     */
    private String foodexplain;

    /**
     * 食品图片
     */
    private String foodimg;

    /**
     * 食品价格
     */
    private BigDecimal foodprice;

    /**
     * 所属商家编号
     */
    private Integer businessid;

    /**
     * 备注
     */
    private String remarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
     * 食品名称
     */
    public String getFoodname() {
        return foodname;
    }

    /**
     * 食品名称
     */
    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    /**
     * 食品介绍
     */
    public String getFoodexplain() {
        return foodexplain;
    }

    /**
     * 食品介绍
     */
    public void setFoodexplain(String foodexplain) {
        this.foodexplain = foodexplain;
    }

    /**
     * 食品图片
     */
    public String getFoodimg() {
        return foodimg;
    }

    /**
     * 食品图片
     */
    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }

    /**
     * 食品价格
     */
    public BigDecimal getFoodprice() {
        return foodprice;
    }

    /**
     * 食品价格
     */
    public void setFoodprice(BigDecimal foodprice) {
        this.foodprice = foodprice;
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
     * 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        Food other = (Food) that;
        return (this.getFoodid() == null ? other.getFoodid() == null : this.getFoodid().equals(other.getFoodid()))
            && (this.getFoodname() == null ? other.getFoodname() == null : this.getFoodname().equals(other.getFoodname()))
            && (this.getFoodexplain() == null ? other.getFoodexplain() == null : this.getFoodexplain().equals(other.getFoodexplain()))
            && (this.getFoodimg() == null ? other.getFoodimg() == null : this.getFoodimg().equals(other.getFoodimg()))
            && (this.getFoodprice() == null ? other.getFoodprice() == null : this.getFoodprice().equals(other.getFoodprice()))
            && (this.getBusinessid() == null ? other.getBusinessid() == null : this.getBusinessid().equals(other.getBusinessid()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFoodid() == null) ? 0 : getFoodid().hashCode());
        result = prime * result + ((getFoodname() == null) ? 0 : getFoodname().hashCode());
        result = prime * result + ((getFoodexplain() == null) ? 0 : getFoodexplain().hashCode());
        result = prime * result + ((getFoodimg() == null) ? 0 : getFoodimg().hashCode());
        result = prime * result + ((getFoodprice() == null) ? 0 : getFoodprice().hashCode());
        result = prime * result + ((getBusinessid() == null) ? 0 : getBusinessid().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", foodid=").append(foodid);
        sb.append(", foodname=").append(foodname);
        sb.append(", foodexplain=").append(foodexplain);
        sb.append(", foodimg=").append(foodimg);
        sb.append(", foodprice=").append(foodprice);
        sb.append(", businessid=").append(businessid);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}