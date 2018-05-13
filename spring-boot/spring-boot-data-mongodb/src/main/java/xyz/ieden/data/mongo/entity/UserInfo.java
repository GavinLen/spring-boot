package xyz.ieden.data.mongo.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@Document(collection = "user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String foreName;
    private String lastName;
    private String password;
    private Integer age;
    private Date createDateTime;
    private Integer status;

    public UserInfo() {
    }

    public UserInfo(String foreName, String lastName, String password, Integer age) {
        this.foreName = foreName;
        this.lastName = lastName;
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

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
