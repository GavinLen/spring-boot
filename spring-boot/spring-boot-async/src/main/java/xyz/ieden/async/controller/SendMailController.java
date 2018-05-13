package xyz.ieden.async.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ieden.async.service.IMailService;
import xyz.ieden.entity.Result;
import xyz.ieden.utils.RandomStrUtils;
import xyz.ieden.utils.ResultUtils;

/**
 *
 * @author Gavin
 * @date 2018.05.12
 */
@RestController
@RequestMapping(value = "mail")
public class SendMailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMailController.class);

    @Autowired
    private IMailService mailService;

    @GetMapping(value = "simple")
    public Result<Boolean> sendSimpleMail() {
        LOGGER.info("Request Send Simple Mail.");
        Result<Boolean> result = ResultUtils.createResult();
        JSONObject reqParam = new JSONObject();
        reqParam.put("id", RandomStrUtils.getStrByUid());
        reqParam.put("toUser", "tom");
        reqParam.put("subject", "测试发送邮件");
        mailService.sendSimpleMail(reqParam);
        mailService.sendSimpleMail(reqParam);
        LOGGER.info("Request Send Simple Mail Send.");
        return result;
    }
}
