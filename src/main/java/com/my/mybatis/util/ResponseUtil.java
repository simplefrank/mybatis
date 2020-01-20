package com.my.mybatis.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
    public static void outputSuccess(HttpServletResponse response, Object data){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter pw = response.getWriter()) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "请求成功");
            if (data != null) {
                map.put("data", JSON.toJSONString(data, SerializerFeature.WriteMapNullValue));
            }
            pw.write(JSON.toJSONString(map, SerializerFeature.WriteMapNullValue));
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> outputSuccess(Object data){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "请求成功");
        if (data != null){
            map.put("data", JSON.toJSONString(data, SerializerFeature.WriteMapNullValue));
        }
        return map;
    }
}
