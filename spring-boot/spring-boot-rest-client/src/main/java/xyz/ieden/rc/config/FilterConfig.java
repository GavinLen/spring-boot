package xyz.ieden.rc.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ieden.rc.filter.MyFilter;
import xyz.ieden.rc.filter.ReqVerifyFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 14:07
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("MyFilter");
        registrationBean.setFilter(new MyFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("name", "张三");
        registrationBean.setInitParameters(initParam);
        Collection<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<ReqVerifyFilter> reqVerifyFilterFilterRegistrationBean() {
        FilterRegistrationBean<ReqVerifyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("ReqVerifyFilter");
        registrationBean.setFilter(new ReqVerifyFilter());
        Map<String, String> initParam = new HashMap<>();
        initParam.put("name", "李四");
        registrationBean.setInitParameters(initParam);
        Collection<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(2);
        return registrationBean;
    }


    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
}
