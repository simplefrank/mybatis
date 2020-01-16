package com.my.mybatis.config;

import com.my.mybatis.filter.AuthorityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy("authorityFilter"));
        registration.addUrlPatterns("/**");
        registration.setName("AuthorityFilter");
        registration.setOrder(1);
        registration.setEnabled(false);
        return registration;
    }

    @Bean
    public AuthorityFilter authorityFilter(){
        return new AuthorityFilter();
    }
}
