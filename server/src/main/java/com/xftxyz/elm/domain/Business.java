package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName business
 */
@TableName(value ="business")
public class Business implements Serializable {
    /**
     * 商家编号
     */
    @TableId(type = IdType.AUTO)
    private Integer businessid;

    /**
     * 商家名称
     */
    private String businessname;

    /**
     * 商家地址
     */
    private String businessaddress;

    /**
     * 商家介绍
     */
    private String businessexplain;

    /**
     * 商家图片（base64）
     */
    private String businessimg;

    /**
     * 点餐分类
     */
    private Integer ordertypeid;

    /**
     * 起送费
     */
    private BigDecimal starprice;

    /**
     * 配送费
     */
    private BigDecimal deliveryprice;

    /**
     * 备注
     */
    private String remarks;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
     * 商家名称
     */
    public String getBusinessname() {
        return businessname;
    }

    /**
     * 商家名称
     */
    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    /**
     * 商家地址
     */
    public String getBusinessaddress() {
        return businessaddress;
    }

    /**
     * 商家地址
     */
    public void setBusinessaddress(String businessaddress) {
        this.businessaddress = businessaddress;
    }

    /**
     * 商家介绍
     */
    public String getBusinessexplain() {
        return businessexplain;
    }

    /**
     * 商家介绍
     */
    public void setBusinessexplain(String businessexplain) {
        this.businessexplain = businessexplain;
    }

    /**
     * 商家图片（base64）
     */
    public String getBusinessimg() {
        return businessimg;
    }

    /**
     * 商家图片（base64）
     */
    public void setBusinessimg(String businessimg) {
        this.businessimg = businessimg;
    }

    /**
     * 点餐分类
     */
    public Integer getOrdertypeid() {
        return ordertypeid;
    }

    /**
     * 点餐分类
     */
    public void setOrdertypeid(Integer ordertypeid) {
        this.ordertypeid = ordertypeid;
    }

    /**
     * 起送费
     */
    public BigDecimal getStarprice() {
        return starprice;
    }

    /**
     * 起送费
     */
    public void setStarprice(BigDecimal starprice) {
        this.starprice = starprice;
    }

    /**
     * 配送费
     */
    public BigDecimal getDeliveryprice() {
        return deliveryprice;
    }

    /**
     * 配送费
     */
    public void setDeliveryprice(BigDecimal deliveryprice) {
        this.deliveryprice = deliveryprice;
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
        Business other = (Business) that;
        return (this.getBusinessid() == null ? other.getBusinessid() == null : this.getBusinessid().equals(other.getBusinessid()))
            && (this.getBusinessname() == null ? other.getBusinessname() == null : this.getBusinessname().equals(other.getBusinessname()))
            && (this.getBusinessaddress() == null ? other.getBusinessaddress() == null : this.getBusinessaddress().equals(other.getBusinessaddress()))
            && (this.getBusinessexplain() == null ? other.getBusinessexplain() == null : this.getBusinessexplain().equals(other.getBusinessexplain()))
            && (this.getBusinessimg() == null ? other.getBusinessimg() == null : this.getBusinessimg().equals(other.getBusinessimg()))
            && (this.getOrdertypeid() == null ? other.getOrdertypeid() == null : this.getOrdertypeid().equals(other.getOrdertypeid()))
            && (this.getStarprice() == null ? other.getStarprice() == null : this.getStarprice().equals(other.getStarprice()))
            && (this.getDeliveryprice() == null ? other.getDeliveryprice() == null : this.getDeliveryprice().equals(other.getDeliveryprice()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBusinessid() == null) ? 0 : getBusinessid().hashCode());
        result = prime * result + ((getBusinessname() == null) ? 0 : getBusinessname().hashCode());
        result = prime * result + ((getBusinessaddress() == null) ? 0 : getBusinessaddress().hashCode());
        result = prime * result + ((getBusinessexplain() == null) ? 0 : getBusinessexplain().hashCode());
        result = prime * result + ((getBusinessimg() == null) ? 0 : getBusinessimg().hashCode());
        result = prime * result + ((getOrdertypeid() == null) ? 0 : getOrdertypeid().hashCode());
        result = prime * result + ((getStarprice() == null) ? 0 : getStarprice().hashCode());
        result = prime * result + ((getDeliveryprice() == null) ? 0 : getDeliveryprice().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", businessid=").append(businessid);
        sb.append(", businessname=").append(businessname);
        sb.append(", businessaddress=").append(businessaddress);
        sb.append(", businessexplain=").append(businessexplain);
        sb.append(", businessimg=").append(businessimg);
        sb.append(", ordertypeid=").append(ordertypeid);
        sb.append(", starprice=").append(starprice);
        sb.append(", deliveryprice=").append(deliveryprice);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}