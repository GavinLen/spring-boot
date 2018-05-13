package xyz.ieden.mail.service;

import com.alibaba.fastjson.JSONObject;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;

/**
 * @author Gavin
 * @date 2018.05.12
 */
public interface IMailService {

    /**
     * 发送简单邮件
     *
     * @param reqParam
     * @return
     */
    Result<Boolean> sendMimeMail(JSONObject reqParam) throws EdenException;

    /**
     * 发送简单邮件
     *
     * @param reqParam
     * @return
     */
    Result<Boolean> sendSimpleMail(JSONObject reqParam) throws EdenException;

}
