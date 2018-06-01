package com.moris.user.entity;

/**
 * 用户记录
 */
public class UserRecord {

    // 记录ID
    private long   id;
    // 用户Id
    private long   userId;
    // 操作系统 如：android iphone
    private String osType;
    private String imei;
    // 记录时间
    private long   time;
    // 描述
    private String msg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "UserRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", osType='" + osType + '\'' +
                ", imei='" + imei + '\'' +
                ", time=" + time +
                ", msg='" + msg + '\'' +
                '}';
    }
}
