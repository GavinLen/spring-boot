package xyz.ieden.ws.entity;

import java.util.Date;

/**
 * @author ThinkPad
 * @date Created by 2018/5/18 9:42
 */
public class ServerMessage {

    private String respMessage;
    private Date createDate;

    // Setter and Getter Method
    
    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
