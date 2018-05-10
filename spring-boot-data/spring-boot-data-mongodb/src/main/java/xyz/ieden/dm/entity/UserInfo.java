package xyz.ieden.dm.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ThinkPad
 * @date Created by 2018/5/10 9:56
 */
@Document(collection = "user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1L;
    @Id
    private String id;
    private String username;
    private String password;
    private Integer age;
    private Date createTime;

    public UserInfo() {
    }

    public UserInfo(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // Setter and Getter Method
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
