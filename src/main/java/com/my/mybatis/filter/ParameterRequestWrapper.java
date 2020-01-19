package com.my.mybatis.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ParameterRequestWrapper extends HttpServletRequestWrapper {

    /**
     * 参数表
     */
    private Map<String, String[]> params = new HashMap<>();

    public ParameterRequestWrapper(HttpServletRequest request) {
        super(request);
        params.putAll(request.getParameterMap());
    }

    public ParameterRequestWrapper(HttpServletRequest request, Map<String, Object> extendParams) {
        this(request);
        addAllParams(extendParams);
    }

    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if (values == null || values.length == 0){
            return null;
        }
        return values[0];
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(params.keySet());
    }

    /**
     *将新增参数加入参数表
     *
     * @param extendParams 新增的参数
     */
    private void addAllParams(Map<String, Object> extendParams){
        for (Map.Entry<String, Object> entry : extendParams.entrySet()){
            addParam(entry.getKey(), entry.getValue());
        }
    }

    /**
     * 添加单个键值对至参数表
     *
     * @param key 键
     * @param value 值
     */
    private void addParam(String key, Object value){
        if (value != null){
            if (value instanceof String[]){
                params.put(key, (String[]) value);
            } else if (value instanceof String){
                params.put(key, new String[]{(String) value});
            } else {
                params.put(key, new String[]{String.valueOf(value)});
            }
        }
    }

}
