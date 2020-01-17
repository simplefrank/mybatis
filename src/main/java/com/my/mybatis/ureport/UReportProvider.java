package com.my.mybatis.ureport;

import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;

import java.io.InputStream;
import java.util.List;
//未完成
public class UReportProvider implements ReportProvider {

    private static final String STORE_NAME = "自定义存储";

    private String prefix = "ureport.";
    @Override
    public InputStream loadReport(String s) {
        return null;
    }

    @Override
    public void deleteReport(String s) {

    }

    @Override
    public List<ReportFile> getReportFiles() {
        return null;
    }

    @Override
    public void saveReport(String s, String s1) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean disabled() {
        return false;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
