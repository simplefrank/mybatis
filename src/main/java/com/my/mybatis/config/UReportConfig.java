package com.my.mybatis.config;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:ureport.xml")
@Configuration
public class UReportConfig {

    /**
     * UReportServlet加入容器
     *
     * @return servlet注册器
     */
    @Bean
    public ServletRegistrationBean<UReportServlet> servletRegistrationBean(){
        return new ServletRegistrationBean<>(new UReportServlet(), "/ureport/*");
    }
}
