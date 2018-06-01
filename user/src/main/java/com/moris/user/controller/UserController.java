package com.moris.user.controller;

import com.moris.user.controller.task.UserTask;
import com.moris.user.entity.User;
import com.moris.user.entity.UserInfo;
import com.moris.user.entity.UserSecurity;
import com.moris.user.service.UserInfoService;
import com.moris.user.service.UserRecordService;
import com.moris.user.service.UserSecurityService;
import com.moris.user.service.UserService;
import com.moris.user.utils.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用户管理
 */
@RestController
public class UserController {

    @Autowired
    UserInfoService     userInfoService;
    @Autowired
    UserService         userService;
    @Autowired
    UserRecordService   userRecordService;
    @Autowired
    UserSecurityService userSecurityService;

    /**
     * 注册
     * {
     * "param": {
     * "nickname": "liudong2",
     * "userPassword": "dsaf213",
     * "phone": "1234",
     * "phoneCode": "+86"
     * },
     * "osType": "android",
     * "imei": "G688535GHISLF"
     * }
     * 返回：用户完整信息(具体见代码)
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramStr = request.getParameter("param");
        String osType = request.getParameter("osType");
        String imei = request.getParameter("imei");
        if (!TextUtils.isEmpty(paramStr)) {
            String resultParamStr = EncryptionUtil.decoderBase64(paramStr);// Base64解密
            JSONObject paramObject = new JSONObject(resultParamStr);
            String nickname = JSONUtil.getString(paramObject, "nickname");
            String password = JSONUtil.getString(paramObject, "userPassword");
            String phone = JSONUtil.getString(paramObject, "phone");
            String phoneCode = JSONUtil.getString(paramObject, "phoneCode");
            // 校验用户是否存在
            if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(phoneCode)) {
                PrintToClient.printErrorMsgToClient(response, "手机号不能为空");
                return;
            }
            User user = userService.findUserByPhone(phone, phoneCode);
            if (user != null) {
                PrintToClient.printErrorMsgToClient(response, "当前用户已经存在");
                return;
            }
            // 验证通过
            if (!PasswordUtil.isUsefulPassword(password)) {
                PrintToClient.printErrorMsgToClient(response, "密码不合法");
                return;
            }
            // 用户表
            user = new User();
            user.setRegisterTime(System.currentTimeMillis());
            user.setAccessToken(UserTask.genAccessToken());
            user.setUserName(phoneCode + phone);
            user.setPhone(phone);
            user.setUserPassword(password);
            user.setPhoneCode(phoneCode);
            user.setRegisterImei(imei);
            user.setNowImei(imei);
            long userId = userService.insertUser(user);
            // 用户信息表
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(userId);
            if (TextUtils.isEmpty(nickname)) {
                nickname = "MORIS用戶_" + userId;
            }
            userInfo.setNickname(nickname);
            userInfoService.insertUserInfo(userInfo);
            // 返回給客戶端完整用戶数据
            JSONObject resultJsonObject = UserTask.getUserInfoByJson(userInfo, user);
            PrintToClient.printDataToClient(response, resultJsonObject.toString());
            // 用户操作记录表
            userRecordService.insertUserRecord(UserTask.userRecord(userId, osType, imei, "注册"));
        } else {
            PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_REQUEST);
        }
    }

    /**
     * 登录
     * 请求：{
     * "param": {
     * "userPassword": "1234",
     * "phone":"123134",
     * "phoneCode":"+86"
     * },
     * "osType": "android",
     * "imei": "G688535GHISLF"
     * }
     * 返回：用户完整信息(具体见代码)
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramStr = request.getParameter("param");
        String osType = request.getParameter("osType");
        String imei = request.getParameter("imei");
        if (!TextUtils.isEmpty(paramStr)) {
            String resultParamStr = EncryptionUtil.decoderBase64(paramStr);// Base64解密
            JSONObject paramObject = new JSONObject(resultParamStr);
            String userPassword = JSONUtil.getString(paramObject, "userPassword");
            String phone = JSONUtil.getString(paramObject, "phone");
            String phoneCode = JSONUtil.getString(paramObject, "phoneCode");
            // 用户名和密码校验
            if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(phoneCode)) {
                PrintToClient.printErrorMsgToClient(response, "手机号不能为空");
                return;
            }
            User user = userService.findUserByPhone(phone, phoneCode);
            if (user == null) {
                PrintToClient.printErrorMsgToClient(response, "用户不存在");
                return;
            }
            System.out.println("==========================\n" +
                    "userPassword = " + userPassword + "\n" +
                    "user.getUserPassword = " + user.getUserPassword() + "\n" +
                    "==========================");
            if (!TextUtils.equals(user.getUserPassword(), userPassword)) {
                PrintToClient.printErrorMsgToClient(response, "密码错误");
                // 用户操作记录表
                userRecordService.insertUserRecord(UserTask.userRecord(user.getUserId(), osType, imei, "登录密码错误"));
                return;
            }
            user.setLoginTime(System.currentTimeMillis());
            user.setAccessToken(UserTask.genAccessToken());
            userService.updateUser(user);
            // 登录成功，直接返回用户信息
            UserInfo userInfo = userInfoService.findUserInfo(user.getUserId());
            JSONObject resultJsonObject = UserTask.getUserInfoByJson(userInfo, user);
            PrintToClient.printDataToClient(response, resultJsonObject.toString());
            // 用户操作记录表
            userRecordService.insertUserRecord(UserTask.userRecord(user.getUserId(), osType, imei, "登录"));
        } else {
            PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_REQUEST);
        }
    }

    /**
     * 忘记密码 - 注册手机
     * 请求：{
     * "param": {
     * "phone":"123134",
     * "phoneCode":"+86",
     * "imei":"HUHSDKFHUS68768SJI",
     * "password":"daf",
     * },
     * "osType": "android",
     * "imei": "G688535GHISLF"
     * }
     * 返回：用户完整信息(具体见代码)
     */
    @RequestMapping(value = "/forget_password/imei", method = RequestMethod.POST)
    public void forgetPasswordByImei(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramStr = request.getParameter("param");
        String osType = request.getParameter("osType");
        String imei = request.getParameter("imei");
        if (!TextUtils.isEmpty(paramStr)) {
            String resultParamStr = EncryptionUtil.decoderBase64(paramStr);// Base64解密
            JSONObject paramObject = new JSONObject(resultParamStr);
            String password = JSONUtil.getString(paramObject, "password");
            String phone = JSONUtil.getString(paramObject, "phone");
            String phoneCode = JSONUtil.getString(paramObject, "phoneCode");
            String registerImei = JSONUtil.getString(paramObject, "imei");
            // 校验
            User user = userService.findUserByPhone(phone, phoneCode);
            if (user == null) {
                PrintToClient.printErrorMsgToClient(response, "用户不存在");
                return;
            }
            if (!TextUtils.equals(user.getRegisterImei(), registerImei)) {
                PrintToClient.printErrorMsgToClient(response, "请使用注册时使用的手机或使用密保验证方式");
                return;
            }
            // 验证通过
            if (!PasswordUtil.isUsefulPassword(password)) {
                PrintToClient.printErrorMsgToClient(response, "密码不合法");
                return;
            }
            user.setUserPassword(password);
            boolean isUpdateSuccess = userService.updateUser(user);
            if (isUpdateSuccess) {
                PrintToClient.printSuccessMsgToClient(response);
            }
            // 用户操作记录表
            userRecordService.insertUserRecord(UserTask.userRecord(user.getUserId(), osType, imei, "使用本地手机修改密码"));
        } else {
            PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_REQUEST);
        }
    }

    /**
     * 忘记密码 - 密保问题
     * 请求：{
     * "param": {
     * "phone":"123134",
     * "phoneCode":"+86",
     * "securityKey":"",
     * "securityValue":"",
     * "password":"daf",
     * },
     * "osType": "android",
     * "imei": "G688535GHISLF"
     * }
     * 返回：用户完整信息(具体见代码)
     */
    @RequestMapping(value = "/forget_password/security", method = RequestMethod.POST)
    public void forgetPsdBySecurity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramStr = request.getParameter("param");
        String osType = request.getParameter("osType");
        String imei = request.getParameter("imei");
        if (!TextUtils.isEmpty(paramStr)) {
            String resultParamStr = EncryptionUtil.decoderBase64(paramStr);// Base64解密
            JSONObject paramObject = new JSONObject(resultParamStr);
            String password = JSONUtil.getString(paramObject, "password");
            String phone = JSONUtil.getString(paramObject, "phone");
            String phoneCode = JSONUtil.getString(paramObject, "phoneCode");
            String securityKey = JSONUtil.getString(paramObject, "securityKey");
            String securityValue = JSONUtil.getString(paramObject, "securityValue");
            // 密保不为空
            if (TextUtils.isEmpty(securityKey) || TextUtils.isEmpty(securityValue)) {
                PrintToClient.printErrorMsgToClient(response, "密保参数不能为空");
                return;
            }
            // 用户校验
            User user = userService.findUserByPhone(phone, phoneCode);
            if (user == null) {
                PrintToClient.printErrorMsgToClient(response, "用户不存在");
                return;
            }
            // 密保校验
            List<UserSecurity> userSecurityList = userSecurityService.findUserSecurity(user.getUserId());
            if (userSecurityList == null || userSecurityList.size() == 0) { // 将当前密保问题直接设置为有效密保问题
                UserSecurity userSecurity = new UserSecurity();
                userSecurity.setSecurityKey(securityKey);
                userSecurity.setSecurityValue(securityValue);
                userSecurity.setUserId(user.getUserId());
                userSecurityService.insertUserSecurity(userSecurity);
            } else { // 校验
                boolean isUseful = false;
                for (UserSecurity userSecurity : userSecurityList) {
                    if (TextUtils.equals(userSecurity.getSecurityKey(), securityKey) && TextUtils.equals(userSecurity.getSecurityValue(), securityValue)) {
                        isUseful = true;
                        break;
                    }
                }
                if (!isUseful) {
                    PrintToClient.printErrorMsgToClient(response, "密保错误");
                    return;
                }
            }
            // 验证通过，修改密码
            if (!PasswordUtil.isUsefulPassword(password)) {
                PrintToClient.printErrorMsgToClient(response, "密码不合法");
                return;
            }
            user.setUserPassword(password);
            boolean isUpdateSuccess = userService.updateUser(user);
            if (isUpdateSuccess) {
                PrintToClient.printSuccessMsgToClient(response);
            }
            // 用户操作记录表
            userRecordService.insertUserRecord(UserTask.userRecord(user.getUserId(), osType, imei, "使用密保问题修改密码"));
        } else {
            PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_REQUEST);
        }
    }

    /**
     * 更新
     * 请求：{
     * "param": {
     * "userId":123132,
     * "token": "FSAJJIOFDI473294FJIJ",
     * "nickName": "liudong",
     * "iconPath":"https://...",
     * "sex":"男",
     * "signature":"xxx",
     * "birthYear":1992,
     * "birthMonth":9,
     * "birthDay":12,
     * "locationId":""
     * },
     * "osType": "android",
     * "imei": "G688535GHISLF"
     * }
     * 返回：用户完整信息(具体见代码)
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String paramStr = request.getParameter("param");
        String osType = request.getParameter("osType");
        String imei = request.getParameter("imei");
        if (!TextUtils.isEmpty(paramStr)) {
            String resultParamStr = EncryptionUtil.decoderBase64(paramStr);// Base64解密
            JSONObject paramObject = new JSONObject(resultParamStr);
            long userId = JSONUtil.getLong(paramObject, "userId");
            if (userId == 0) {
                PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_PARAM);
                return;
            }
            String token = JSONUtil.getString(paramObject, "token");
            User user = userService.findUserById(userId);
            if (!TextUtils.equals(token, user.getAccessToken())) {
                PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_TOKEN);
                return;
            }
            String nickName = JSONUtil.getString(paramObject, "nickName");
            String iconPath = JSONUtil.getString(paramObject, "iconPath");
            String sex = JSONUtil.getString(paramObject, "sex");
            String signature = JSONUtil.getString(paramObject, "signature");
            int birthYear = JSONUtil.getInt(paramObject, "birthYear");
            int birthMonth = JSONUtil.getInt(paramObject, "birthMonth");
            int birthDay = JSONUtil.getInt(paramObject, "birthDay");
            String locationId = JSONUtil.getString(paramObject, "locationId");
            // 更新其它
            UserInfo userInfo = new UserInfo();
            userInfo.setNickname(nickName);
            userInfo.setUserId(userId);
            userInfo.setIconPath(iconPath);
            userInfo.setSex(sex);
            userInfo.setSignature(signature);
            userInfo.setBirthYear(birthYear);
            userInfo.setBirthMonth(birthMonth);
            userInfo.setBirthDay(birthDay);
            userInfo.setLocationId(locationId);
            boolean isUpdateSuccess = userInfoService.updateUserInfo(userInfo);
            if (isUpdateSuccess) {
                // 更新成功，返回用户信息
                UserInfo realUserInfo = userInfoService.findUserInfo(userId);
                JSONObject resultJsonObject = UserTask.getUserInfoByJson(realUserInfo, user);
                PrintToClient.printDataToClient(response, resultJsonObject.toString());
            }
            // 用户操作记录表
            userRecordService.insertUserRecord(UserTask.userRecord(userId, osType, imei, "更新用户信息"));
        } else {
            PrintToClient.printErrorMsgToClient(response, PrintToClient.ERROR_REQUEST);
        }
    }
}
