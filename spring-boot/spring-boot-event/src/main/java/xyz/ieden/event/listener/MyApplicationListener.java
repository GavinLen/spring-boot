package xyz.ieden.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author lianghongwei01
 * @date 2018/7/2 18:06
 */
@Component
public class MyApplicationListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationListener.class);

    /**
     * 监听 ApplicationFailedEvent 事件
     * @param event
     */
    @EventListener
    public void listenerApplicationFailedEvent(ApplicationFailedEvent event) {
        LOGGER.info("Listener Application Failed Event ");
    }

    /**
     * 监听 ApplicationPreparedEvent 事件
     *
     * @param event
     */
    @EventListener
    public void listenerApplicationPreparedEvent(ApplicationPreparedEvent event) {
        LOGGER.info("Listener Application Prepared Event.");
        LOGGER.info(event.toString());
    }

    /**
     * 监听 ApplicationEnvironmentPreparedEvent 事件
     *
     * @param event
     */
    @EventListener
    public void listenerApplicationEnvironmentPreparedEvent(ApplicationEnvironmentPreparedEvent event) {
        LOGGER.info("Listener Application Environment Prepared Event.");
        LOGGER.info(event.toString());
    }

    /**
     * 监听 ApplicationStartedEvent 事件
     *
     * @param event
     */
    @EventListener
    public void listenerApplicationStartedEvent(ApplicationStartedEvent event) {
        LOGGER.info("Listener Application Started Event.");
        LOGGER.info(event.toString());
    }

}
