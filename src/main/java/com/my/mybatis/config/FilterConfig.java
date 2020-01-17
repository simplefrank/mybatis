package com.my.mybatis.config;

import com.my.mybatis.filter.AuthorityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthorityFilter> filterRegistrationBean(AuthorityFilter authorityFilter){
        FilterRegistrationBean<AuthorityFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(authorityFilter);
        registration.addUrlPatterns("/*");
        registration.setName("AuthorityFilter");
        registration.setOrder(1);
        return registration;
    }
}
