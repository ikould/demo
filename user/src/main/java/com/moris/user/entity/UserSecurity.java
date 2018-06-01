package com.moris.user.entity;

/**
 * 用户密保
 */
public class UserSecurity {

    private int    id;
    private long   userId;
    private String securityKey;
    private String securityValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getSecurityValue() {
        return securityValue;
    }

    public void setSecurityValue(String securityValue) {
        this.securityValue = securityValue;
    }

    @Override
    public String toString() {
        return "UserSecurity{" +
                "id=" + id +
                ", userId=" + userId +
                ", securityKey='" + securityKey + '\'' +
                ", securityValue='" + securityValue + '\'' +
                '}';
    }
}
