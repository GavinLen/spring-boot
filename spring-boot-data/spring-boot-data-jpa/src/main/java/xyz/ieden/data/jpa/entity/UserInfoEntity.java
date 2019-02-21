package xyz.ieden.data.jpa.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lianghongwei01
 * @date 2019/2/21 19:03
 */
@Entity
@Table(name = "t_user_info", uniqueConstraints = {
        @UniqueConstraint(name = "USER_AUTH_PHONE", columnNames = "phone"),
        @UniqueConstraint(name = "USER_AUTH_EMAIL", columnNames = "email")
})
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1746614874116793918L;

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "email")
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
