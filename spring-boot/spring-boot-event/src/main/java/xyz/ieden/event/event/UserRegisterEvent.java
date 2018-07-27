package xyz.ieden.event.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import xyz.ieden.event.entity.UserInfo;

/**
 * @author lianghongwei01
 * @date 2018/7/2 18:24
 */
public class UserRegisterEvent extends ApplicationEvent {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegisterEvent.class);

    public UserRegisterEvent(Object source, UserInfo userInfo) {
        super(source);
    }
}
