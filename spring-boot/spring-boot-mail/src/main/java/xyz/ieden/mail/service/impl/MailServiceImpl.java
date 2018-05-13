package xyz.ieden.mail.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;
import xyz.ieden.mail.component.MailMessageComponent;
import xyz.ieden.mail.entity.MimeMailMessageInfo;
import xyz.ieden.mail.entity.SimpleMailMessageInfo;
import xyz.ieden.mail.service.IMailService;

/**
 *
 * @author Gavin
 * @date 2018.05.12
 */
@Service
public class MailServiceImpl implements IMailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private MailMessageComponent mailMessageComponent;

    @Override
    public Result<Boolean> sendMimeMail(JSONObject reqParam) throws EdenException {
        MimeMailMessageInfo info = reqParam.toJavaObject(MimeMailMessageInfo.class);
        Result<Boolean> result = mailMessageComponent.sendMimeMail(info);

        return result;
    }

    @Override
    public Result<Boolean> sendSimpleMail(JSONObject reqParam) throws EdenException {
        SimpleMailMessageInfo simpleMailMessageInfo = reqParam.toJavaObject(SimpleMailMessageInfo.class);
        Result<Boolean> result = mailMessageComponent.sendSimpleMail(simpleMailMessageInfo);
        return result;
    }
}
