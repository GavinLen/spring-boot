package xyz.ieden.rc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ieden.entity.Result;
import xyz.ieden.utils.ResultUtils;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 13:51
 */
@RestController
@RequestMapping(value = "ping")
public class PingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @GetMapping(value = "/to")
    public Result<String> reqPing() {
        LOGGER.info("Request Ping.");
        Result<String> result = ResultUtils.createResult();
        String respData = "Pang";
        LOGGER.info(respData);
        result.setData(respData);
        return result;
    }

}
