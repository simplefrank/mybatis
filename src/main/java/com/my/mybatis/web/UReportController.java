package com.my.mybatis.web;

import com.bstek.ureport.Utils;
import com.bstek.ureport.export.ExportManager;
import com.bstek.ureport.export.html.HtmlReport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class UReportController {
    //此处暂时只有传test时有效
    @RequestMapping("/export/html/{fileName}")
    public Object exportHtml(@NotBlank(message = "文件名不能为空") @PathVariable("fileName") String fileName, HttpServletRequest request){
        Map<String, Object> params = new HashMap<>();
        params.put("id", request.getParameter("id"));
        String realFileName = "classpath:ureport/" + fileName + ".ureport.xml";
        ExportManager exportManager = (ExportManager) Utils.getApplicationContext().getBean(ExportManager.BEAN_ID);
        HtmlReport htmlReport = exportManager.exportHtml(realFileName, request.getContextPath(), params);
        StringBuilder sb = new StringBuilder();
        //输出CSS样式
        sb.append("<style type=\"text/css\">");
        sb.append(htmlReport.getStyle());
        sb.append("</style>");
        //输出报表内容
        sb.append(htmlReport.getContent());
        return sb;
    }
}
