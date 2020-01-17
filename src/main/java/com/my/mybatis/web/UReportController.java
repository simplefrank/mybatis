package com.my.mybatis.web;

import com.bstek.ureport.Utils;
import com.bstek.ureport.export.ExportManager;
import com.bstek.ureport.export.html.HtmlReport;
import com.my.mybatis.util.ResponseUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class UReportController {
    @RequestMapping("/export/html/{fileName}")
    public void exportHtml(@NotBlank(message = "文件名不能为空") @PathVariable("fileName") String fileName, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = new HashMap<>();
        String realFileName = "file:" + fileName + ".ureport.xml";
        ExportManager exportManager = (ExportManager) Utils.getApplicationContext().getBean(ExportManager.BEAN_ID);
        HtmlReport htmlReport = exportManager.exportHtml(realFileName, request.getContextPath(), params);
        StringBuilder sb = new StringBuilder();
        //输出CSS样式
        sb.append("<style type=\"text/css\">");
        sb.append(htmlReport.getStyle());
        sb.append("</style>");
        //输出报表内容
        sb.append(htmlReport.getContent());
        ResponseUtil.outputSuccess(response, sb);
    }
}
