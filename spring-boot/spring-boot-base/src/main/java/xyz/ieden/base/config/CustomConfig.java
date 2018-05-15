package xyz.ieden.base.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 16:50
 */
@Configuration
@PropertySource("classpath:custom.properties")
public class CustomConfig {
    @Value("${user.id}")
    private Integer id;
    @Value("${user.name}")
    private String name;
    @Value("${user.password}")
    private String password;
    @Value("${user.age}")
    private Integer age;

    // Setter and Getter Method

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
