package xyz.ieden.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.ieden.ws.entity.ClientMessage;
import xyz.ieden.ws.entity.ServerMessage;

/**
 * @author ThinkPad
 * @date Created by 2018/5/18 17:37
 */
@Controller
public class SendMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageController.class);

    @MessageMapping(value = {"toTest"})
    public ServerMessage sendMessageToTest(ClientMessage clientMessage) {
        LOGGER.info("[{}] [{}].", clientMessage.getDate(), clientMessage.getMessage());
        ServerMessage serverMessage = new ServerMessage();
        serverMessage.setRespMessage("You Send Message:" + clientMessage.getMessage());
        return serverMessage;
    }

    @MessageMapping(value = {"toDevelop"})
    public ServerMessage sendMessageToDevelop(ClientMessage clientMessage) {
        LOGGER.info("[{}] [{}].", clientMessage.getDate(), clientMessage.getMessage());
        ServerMessage serverMessage = new ServerMessage();
        serverMessage.setRespMessage("You Send Message:" + clientMessage.getMessage());
        return serverMessage;
    }

}
