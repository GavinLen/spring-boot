package xyz.ieden.rest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.ieden.rest.interceptor.MyInterceptor;

/**
 *
 * @author Gavin
 * @date 2018.05.12
 */
@Configuration
public class BaseConfig implements WebMvcConfigurer{

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseConfig.class);


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("BaseConfig.addInterceptors().");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
