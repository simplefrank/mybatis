package com.my.mybatis.common;

import cn.hutool.core.collection.CollectionUtil;
import com.my.mybatis.util.HttpUtil;

import java.util.Map;

public class BaseTest {

    private static final String URL = "http://127.0.0.1:8080/mybatis";

    /**
     * GET请求
     *
     * @param path 请求路径
     * @param params 请求参数
     * @return 返回数据
     */
    protected String get(String path, Map<String, Object> params){
        String paramStr = "?" + parseMapToString(params);
        return HttpUtil.doGet(URL + path + paramStr, null);
    }

    /**
     * POST请求
     * 可以修改添加自己的请求头
     *
     * @param path 请求路径
     * @param params 请求参数
     * @return  返回数据
     */
    protected String post(String path, Map<String, Object> params){
        return HttpUtil.doPost(URL + path, null, parseMapToString(params));
    }

    /**
     * 将参数键值对转换成固定字符串格式
     * "name=jerry&age=12"
     *
     * @param params 参数键值对
     * @return 转换后的字符串
     */
    private String parseMapToString(Map<String, Object> params){
        if (CollectionUtil.isEmpty(params)){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
