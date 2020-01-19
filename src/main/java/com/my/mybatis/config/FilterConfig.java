package com.my.mybatis.config;

import com.my.mybatis.filter.ParameterFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<ParameterFilter> filterRegistrationBean(ParameterFilter parameterFilter){
        FilterRegistrationBean<ParameterFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(parameterFilter);
        registration.addUrlPatterns("/*");
        registration.setName("ParameterFilter");
        registration.setOrder(1);
        return registration;
    }
}
