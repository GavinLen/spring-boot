package xyz.ieden.mail.entity;

import javafx.scene.layout.Priority;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Gavin
 * @date 2018.05.12
 */
public class SimpleMailMessageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * From User List
     */
    private String fromUser;
    /**
     * To User List
     */
    private String[] toUsers;
    /**
     * CC User List
     */
    private String[] ccUsers;
    /**
     * BCC User List
     */
    private String[] bccUsers;
    /**
     * 发送主题
     */
    private String subject;
    /**
     * 发送 text
     */
    private String text;
    /**
     * 简单 text
     */
    private String plainText;
    /**
     * Html text
     */
    private String htmlText;
    /**
     * 回复用户
     */
    private String replyTo;
    /**
     * 发送时间
     */
    private Date sendDate;
    /**
     * 附件 name
     */
    private String fileName;
    /**
     * 附件
     */
    private File file;
    /**
     * 文件类型
     */
    private FileTypeMap fileTypeMap;
    /**
     * 优先级
     */
    private Priority priority;
    /**
     * 验证地址
     */
    private Boolean validateAddresses;

    // Setter and Getter Method
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String[] getToUsers() {
        return toUsers;
    }

    public void setToUsers(String[] toUsers) {
        this.toUsers = toUsers;
    }

    public String[] getCcUsers() {
        return ccUsers;
    }

    public void setCcUsers(String[] ccUsers) {
        this.ccUsers = ccUsers;
    }

    public String[] getBccUsers() {
        return bccUsers;
    }

    public void setBccUsers(String[] bccUsers) {
        this.bccUsers = bccUsers;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
