package com.moris.user.entity;

/**
 * 用戶
 */
public class User {

    private long   id;
    // 用户id
    private long   userId;
    // 用户名
    private String userName;
    // 手机号
    private String phone;
    // 手机区号
    private String phoneCode;
    // 用户密码
    private String userPassword;
    // 获取令牌
    private String accessToken;
    // 注冊时间
    private long   registerTime;
    // 登录时间
    private long   loginTime;
    // 是否垃圾用户0:不是,1:是
    private int    isRubbish;
    // 账号是否被删除0:不是,1:是
    private int    isDelete;
    // 是否已经验证密码
    private int    isSecurity;
    // 注册使用的Imei
    private String registerImei;
    // 当前使用的Imei
    private String nowImei;

    public User() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(long registerTime) {
        this.registerTime = registerTime;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public int getIsRubbish() {
        return isRubbish;
    }

    public void setIsRubbish(int isRubbish) {
        this.isRubbish = isRubbish;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getIsSecurity() {
        return isSecurity;
    }

    public void setIsSecurity(int isSecurity) {
        this.isSecurity = isSecurity;
    }

    public String getRegisterImei() {
        return registerImei;
    }

    public void setRegisterImei(String registerImei) {
        this.registerImei = registerImei;
    }

    public String getNowImei() {
        return nowImei;
    }

    public void setNowImei(String nowImei) {
        this.nowImei = nowImei;
    }
}
