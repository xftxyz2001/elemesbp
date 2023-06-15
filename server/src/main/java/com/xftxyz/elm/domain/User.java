package com.xftxyz.elm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
public class User implements Serializable {
    /**
     * 用户编号
     */
    @TableId
    private String userid;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户性别（1：男； 0：女）
     */
    private Integer usersex;

    /**
     * 用户头像
     */
    private String userimg;

    /**
     * 删除标记（1：正常； 0：删除）
     */
    private Integer deltag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 用户性别（1：男； 0：女）
     */
    public Integer getUsersex() {
        return usersex;
    }

    /**
     * 用户性别（1：男； 0：女）
     */
    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    /**
     * 用户头像
     */
    public String getUserimg() {
        return userimg;
    }

    /**
     * 用户头像
     */
    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    /**
     * 删除标记（1：正常； 0：删除）
     */
    public Integer getDeltag() {
        return deltag;
    }

    /**
     * 删除标记（1：正常； 0：删除）
     */
    public void setDeltag(Integer deltag) {
        this.deltag = deltag;
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
        User other = (User) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUsersex() == null ? other.getUsersex() == null : this.getUsersex().equals(other.getUsersex()))
            && (this.getUserimg() == null ? other.getUserimg() == null : this.getUserimg().equals(other.getUserimg()))
            && (this.getDeltag() == null ? other.getDeltag() == null : this.getDeltag().equals(other.getDeltag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUsersex() == null) ? 0 : getUsersex().hashCode());
        result = prime * result + ((getUserimg() == null) ? 0 : getUserimg().hashCode());
        result = prime * result + ((getDeltag() == null) ? 0 : getDeltag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", usersex=").append(usersex);
        sb.append(", userimg=").append(userimg);
        sb.append(", deltag=").append(deltag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}