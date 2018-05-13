package xyz.ieden.async.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import xyz.ieden.async.service.IMailService;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;
import xyz.ieden.utils.ResultUtils;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@Service
public class MailServiceImpl implements IMailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Override
    @Async
    public Result<Boolean> sendSimpleMail(JSONObject reqParam) throws EdenException {
        LOGGER.info("Send Simple Mail :[{}].", reqParam.toString());
        Result<Boolean> result = ResultUtils.createResult();
        try {
            Thread.sleep(2000);
            LOGGER.info("Send Simple Mail-[{}] Send.", reqParam.getString("id"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
