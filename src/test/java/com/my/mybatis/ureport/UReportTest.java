package com.my.mybatis.ureport;

import com.my.mybatis.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UReportTest extends BaseTest {

    @Test
    public void exportHtml(){
        String path = "/report/export/html/test";
        Map<String, Object> params = new HashMap<>();
        params.put("id", "2");
        System.out.println(get(path, params));
    }
}
