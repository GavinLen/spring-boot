package xyz.ieden.ws.entity;

import java.util.Date;

/**
 * @author ThinkPad
 * @date Created by 2018/5/18 9:41
 */
public class ClientMessage {

    private String message;
    private Date date;

    // Setter and Getter Method

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
