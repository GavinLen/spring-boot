package xyz.ieden.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import xyz.ieden.ws.entity.ServerMessage;

import java.util.Date;

/**
 * @author ThinkPad
 * @date Created by 2018/5/18 17:26
 */
@Controller
public class SubscribeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscribeController.class);

    /**
     * 订阅 test
     *
     * @return
     */
    @SubscribeMapping(value = {"test"})
    public ServerMessage subscribeTest() {
        LOGGER.info("subscribe Test");
        ServerMessage serverMessage = new ServerMessage();
        serverMessage.setRespMessage("You subscribe Test");
        serverMessage.setCreateDate(new Date());
        return serverMessage;
    }

    /**
     * 订阅 develop
     *
     * @return
     */
    @SubscribeMapping(value = {"develop"})
    public ServerMessage subscribeDevelop() {
        LOGGER.info("subscribe Develop");
        ServerMessage serverMessage = new ServerMessage();
        serverMessage.setRespMessage("You subscribe develop");
        serverMessage.setCreateDate(new Date());
        return serverMessage;
    }

}
