package xyz.ieden.rc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 13:47
 */
public class MyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 初始化操作
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String value = filterConfig.getInitParameter("name");
        LOGGER.info("MyFilter.init(), Param:[{}].", value);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("MyFilter.doFilter() Before.");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("MyFilter.doFilter() After.");
    }

    @Override
    public void destroy() {
        LOGGER.info("MyFilter.destroy().");
    }
}
