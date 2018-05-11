package xyz.ieden.es.mysql.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 10:08
 */
@Document(indexName = "shop", type = "user", shards = 3, replicas = 1, refreshInterval = "-1")
public class EsUserInfo {
    @Id
    private String id;
    private String userName;
    private String userPwd;
    private Integer age;
    private String email;
    private Date createTime;
    private Date updateTme;
    private Integer status;

    public EsUserInfo() {
    }

    public EsUserInfo(String id, String userName, String userPwd, Integer age, String email, Integer status) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.age = age;
        this.email = email;
        this.status = status;
    }

    // Setter and Getter Method
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTme() {
        return updateTme;
    }

    public void setUpdateTme(Date updateTme) {
        this.updateTme = updateTme;
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
