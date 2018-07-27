package xyz.ieden.event.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author lianghongwei01
 * @date 2018/7/2 18:31
 */
public class UserInfo {

    private Integer userId;
    private String userName;
    private String password;
    private String email;

    // Setter and Getter Method

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
