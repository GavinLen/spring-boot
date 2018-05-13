package xyz.ieden.rest.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@WebListener
public class MyListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyListener.class);

    /**
     * 初始化时运行
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("MyListener.contextInitialized()");
    }

    /**
     * 销毁时运行
     *
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("MyListener.contextDestroyed()");
    }
}
