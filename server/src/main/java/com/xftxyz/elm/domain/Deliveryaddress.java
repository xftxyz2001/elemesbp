package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName deliveryaddress
 */
@TableName(value ="deliveryaddress")
public class Deliveryaddress implements Serializable {
    /**
     * 送货地址编号
     */
    @TableId(type = IdType.AUTO)
    private Integer daid;

    /**
     * 联系人姓名
     */
    private String contactname;

    /**
     * 联系人性别
     */
    private Integer contactsex;

    /**
     * 联系人电话
     */
    private String contacttel;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 所属用户编号
     */
    private String userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
     * 联系人姓名
     */
    public String getContactname() {
        return contactname;
    }

    /**
     * 联系人姓名
     */
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    /**
     * 联系人性别
     */
    public Integer getContactsex() {
        return contactsex;
    }

    /**
     * 联系人性别
     */
    public void setContactsex(Integer contactsex) {
        this.contactsex = contactsex;
    }

    /**
     * 联系人电话
     */
    public String getContacttel() {
        return contacttel;
    }

    /**
     * 联系人电话
     */
    public void setContacttel(String contacttel) {
        this.contacttel = contacttel;
    }

    /**
     * 送货地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 送货地址
     */
    public void setAddress(String address) {
        this.address = address;
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
        Deliveryaddress other = (Deliveryaddress) that;
        return (this.getDaid() == null ? other.getDaid() == null : this.getDaid().equals(other.getDaid()))
            && (this.getContactname() == null ? other.getContactname() == null : this.getContactname().equals(other.getContactname()))
            && (this.getContactsex() == null ? other.getContactsex() == null : this.getContactsex().equals(other.getContactsex()))
            && (this.getContacttel() == null ? other.getContacttel() == null : this.getContacttel().equals(other.getContacttel()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDaid() == null) ? 0 : getDaid().hashCode());
        result = prime * result + ((getContactname() == null) ? 0 : getContactname().hashCode());
        result = prime * result + ((getContactsex() == null) ? 0 : getContactsex().hashCode());
        result = prime * result + ((getContacttel() == null) ? 0 : getContacttel().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", daid=").append(daid);
        sb.append(", contactname=").append(contactname);
        sb.append(", contactsex=").append(contactsex);
        sb.append(", contacttel=").append(contacttel);
        sb.append(", address=").append(address);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}