package com.my.mybatis.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * HTTP请求工具类，便于单元测试
 * 采用HttpURLConnection类实现
 */
public class HttpUtil {

    /**
     * 发起一个GET请求
     *
     * @param url URL地址和参数
     * @param headers 新增请求头信息
     * @return 返回数据
     */
    public static String doGet(String url, Map<String, String> headers){
        HttpURLConnection connection = null;
        try {
            connection = getConnection(url, headers);
            //设置请求方式
            connection.setRequestMethod("GET");
            connection.connect();
            return handleResult(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    /**
     * 发起一个POST请求
     *
     * @param url URL地址
     * @param headers 新增请求头
     * @param params 参数字符串形式--"name=jerry&age=12"
     * @return 返回数据
     */
    public static String doPost(String url, Map<String, String> headers, String params) {
        HttpURLConnection connection = null;
        OutputStream os = null;
        try {
            connection = getConnection(url, headers);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            os = connection.getOutputStream();
            if (StrUtil.isNotBlank(params)) {
                os.write(params.getBytes(StandardCharsets.UTF_8));
            }
            connection.connect();
            return handleResult(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                connection.disconnect();
                if (os != null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 处理返回数据
     *
     * @param connection HTTP连接
     * @return 连接内部信息
     * @throws IOException
     */
    private static String handleResult(HttpURLConnection connection) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder sbf = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                sbf.append(temp).append("\r\n");
            }
            return sbf.toString();
        }
    }

    /**
     * 获取一个HTTP连接
     *
     * @param url 请求的URL地址
     * @param headers 请求头信息
     * @return  HTTP连接
     * @throws IOException 连接创建失败或开启异常
     */
    private static HttpURLConnection getConnection(String url, Map<String, String> headers) throws IOException {
        // 创建远程URL连接对象
        URL httpURL = new URL(url);
        // 通过URL连接对象开启一个连接，并强制转换成HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) httpURL.openConnection();
        // 设置连接主机服务器超时时间15秒
        connection.setConnectTimeout(15000);
        // 设置读取远程返回数据时间6秒
        connection.setReadTimeout(6000);
        // 设置请求头信息
        connection.addRequestProperty("Accept", "*/*");
        connection.addRequestProperty("Connection", "Keep-Alive");
        connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        if (CollectionUtil.isNotEmpty(headers)){
            for (String key : headers.keySet()){
                connection.addRequestProperty(key, headers.get(key));
            }
        }
        return connection;
    }
}
