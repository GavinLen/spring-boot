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
public class MimeMailMessageInfo extends SimpleMailMessageInfo {

    private static final long serialVersionUID = 1L;

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
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    @Override
    public String getReplyTo() {
        return replyTo;
    }

    @Override
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @Override
    public Date getSendDate() {
        return sendDate;
    }

    @Override
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    public FileTypeMap getFileTypeMap() {
        return fileTypeMap;
    }

    public void setFileTypeMap(FileTypeMap fileTypeMap) {
        this.fileTypeMap = fileTypeMap;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getValidateAddresses() {
        return validateAddresses;
    }

    public void setValidateAddresses(Boolean validateAddresses) {
        this.validateAddresses = validateAddresses;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
