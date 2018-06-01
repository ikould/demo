package com.moris.user.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 加密Util
 */
public class EncryptionUtil {

    /**
     * HMACSHA256加密
     * Base64加密
     */
    public static String hmacSHA256(String data, String key) {
        if (!TextUtils.isEmpty(data) && !TextUtils.isEmpty(key)) {
            return hmacSHA256(data.getBytes(), key.getBytes());
        }
        return null;
    }

    /**
     * HMACSHA256加密
     * Base64加密
     */
    public static String hmacSHA256(byte[] data, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] b = mac.doFinal(data);
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] encodeResult = encoder.encode(b);
            if (encodeResult != null) {
                return new String(encodeResult, "US-ASCII");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用md5加密
     *
     * @param data 待加密的数据
     * @return 加密后的数据
     */
    public static String md5Encrypt(String data) {
        return encrypt("MD5", data);
    }

    /**
     * 加密
     *
     * @param algorithm 加密算法
     * @param data      待加密数据
     * @return 加密结果
     */
    public static String encrypt(String algorithm, String data) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(data.getBytes());
            return StringUtil.byte2HexStr(md.digest());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Base64加密
     */
    public static String encoderBase64(String str) {
        String result = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                Base64.Encoder encoder = Base64.getEncoder();
                byte[] encodeResult = encoder.encode(str.getBytes());
                if (encodeResult != null) {
                    return new String(encodeResult, "US-ASCII");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Base64解密
     */
    public static String decoderBase64(String str) {
        String result = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decoderResult = decoder.decode(str);
                return new String(decoderResult, "US-ASCII");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
