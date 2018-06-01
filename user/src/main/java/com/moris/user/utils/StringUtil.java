package com.moris.user.utils;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * String相关工具类
 */
public class StringUtil {

    // 16 进制各个符号
    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 使第一个字母大写
     *
     * @param str 输入的字符串
     * @return 输出
     */
    public static String capitalizeFirstLetter(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str : String.valueOf(Character.toUpperCase(c)) + str.substring(1);
    }

    /**
     * 对字符串进行utf-8编码
     *
     * @param str 输入的字符串
     */
    public static String utf8Encode(String str) {
        if (!TextUtils.isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    /**
     * 获取双数，个位数前加0
     *
     * @param index 输入
     * @return 输出
     */
    public static String getDoubleNumber(int index) {
        if (index < 10)
            return "0" + index;
        return String.valueOf(index);
    }

    /**
     * 将字符串数组转换以'_,,_'分割的字符串
     *
     * @param strArrays 字符串数组
     * @return 结果
     */
    public static String getStringByArray(String[] strArrays) {
        String resultStr = "";
        if (strArrays != null)
            for (int i = 0; i < strArrays.length; i++) {
                String resource = strArrays[i];
                resultStr += resource;
                if (i != strArrays.length - 1) {
                    resultStr += "_,,_";
                }
            }
        return resultStr;
    }

    /**
     * 将以"_,,_"分割的字符串转换为字符串数组
     *
     * @return String[]
     */
    public static String[] getArraysByStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split("_,,_");
    }

    /**
     * 将JSONArray字符串字符串数组转换以'_,,_'分割的字符串
     *
     * @param jsonArray JSONArray
     * @return 结果
     */
    public static String getStringFromJsonArray(JSONArray jsonArray) throws JSONException {
        String resultStr = "";
        if (jsonArray != null)
            for (int i = 0; i < jsonArray.length(); i++) {
                String resource = jsonArray.getString(i);
                resultStr += resource;
                if (i != jsonArray.length() - 1) {
                    resultStr += "_,,_";
                }
            }
        return resultStr;
    }

    /**
     * byte转16进制
     *
     * @param data byte数据
     * @return 结果
     */
    public static String byte2HexStr(byte[] data) {
        StringBuilder buf = new StringBuilder(data.length << 1);
        for (int i = 0; i < data.length; i++) {
            buf.append(HEX_DIGITS[(data[i] >>> 4) & 0x0f]);
            buf.append(HEX_DIGITS[data[i] & 0x0f]);
        }
        return buf.toString();
    }
}
