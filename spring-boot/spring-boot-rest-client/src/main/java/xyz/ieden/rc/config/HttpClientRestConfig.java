package xyz.ieden.rc.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 11:21
 */
@Configuration
public class HttpClientRestConfig {

    @Autowired
    private ApplicationYmlConfig ymlConfig;

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {

        if (ymlConfig.getMaxTotalConnect() <= 0) {
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setConnectTimeout(ymlConfig.getConnectTimeout());
            factory.setReadTimeout(ymlConfig.getReadTimeout());
            return factory;
        }
        HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(ymlConfig.getMaxTotalConnect())
                .setMaxConnPerRoute(ymlConfig.getMaxConnectPerRoute()).build();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        clientHttpRequestFactory.setConnectTimeout(ymlConfig.getConnectTimeout());
        clientHttpRequestFactory.setReadTimeout(ymlConfig.getReadTimeout());
        clientHttpRequestFactory.setConnectionRequestTimeout(200);
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();

        //重新设置StringHttpMessageConverter字符集为UTF-8，解决中文乱码问题
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (StringHttpMessageConverter.class == item.getClass()) {
                converterTarget = item;
                break;
            }
        }
        if (null != converterTarget) {
            converterList.remove(converterTarget);
        }
        converterList.add(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        //加入FastJson转换器
        converterList.add(new FastJsonHttpMessageConverter4());
        return restTemplate;
    }
}
