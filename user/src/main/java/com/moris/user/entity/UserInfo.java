package com.moris.user.entity;

/**
 * 用戶信息实体类
 */
public class UserInfo {

    // 主键
    private long   id;
    // 外键 用户id
    private long   userId;
    // 昵称
    private String nickname;
    // 头像
    private String iconPath;
    // 性别
    private String sex;
    // 签名
    private String signature;
    // 出生日期-年
    private int    birthYear;
    // 出生日期-月
    private int    birthMonth;
    // 出生日期-日
    private int    birthDay;
    // 地区id
    private String locationId;
    // 用户更新时间
    private long   updateTime;

    public UserInfo() {
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", birthYear=" + birthYear +
                ", birthMonth=" + birthMonth +
                ", birthDay=" + birthDay +
                ", locationId='" + locationId + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
