package com.moris.user.utils;

import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


public class PrintToClient {

    public static final String ERROR_PARAM   = "参数错误";
    public static final String ERROR_TOKEN   = "Token无效";
    public static final String ERROR_REQUEST = "请求不合法";

    /**
     * 回应消息给客户端
     *
     * @throws IOException
     */
    public static void printMsgToClient(HttpServletResponse response,
                                        String json) throws IOException {
        JSONObject jsonFrame = new JSONObject();
        jsonFrame.put("code", 200);
        jsonFrame.put("msg", json);
        PrintWriter pw = response.getWriter();
        pw.print(jsonFrame.toString());
        pw.flush();
        pw.close();
    }

    /**
     * 回应数据给客户端
     *
     * @throws IOException
     */
    public static void printDataToClient(HttpServletResponse response,
                                         String json) throws IOException {
        JSONObject jsonFrame = new JSONObject();
        jsonFrame.put("code", 200);
        jsonFrame.put("data", json);
        PrintWriter pw = response.getWriter();
        pw.print(jsonFrame.toString());
        pw.flush();
        pw.close();
    }

    /**
     * 回应请求错误信息给客户端
     *
     * @throws IOException
     */
    public static void printErrorMsgToClient(HttpServletResponse response)
            throws IOException {
        PrintWriter pw = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("code", 207);
        json.put("msg", "请求错误");
        pw.print(json.toString());
        pw.flush();
        pw.close();
    }

    /**
     * 回应请求错误信息给客户端
     *
     * @throws IOException
     */
    public static void printErrorMsgToClient(HttpServletResponse response, String msg)
            throws IOException {
        PrintWriter pw = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("code", 207);
        json.put("msg", msg);
        pw.print(json.toString());
        pw.flush();
        pw.close();
    }

    /**
     * 回应请求成功信息给客户端
     *
     * @throws IOException
     */
    public static void printSuccessMsgToClient(HttpServletResponse response)
            throws IOException {
        PrintWriter pw = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("msg", "操作成功");
        pw.print(json.toString());
        pw.flush();
        pw.close();
    }
}
