package xyz.ieden.rc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 14:20
 */
public class ReqVerifyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReqVerifyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String value = filterConfig.getInitParameter("name");
        LOGGER.info("ReqVerifyFilter.init(), Param:[{}].", value);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("ReqVerifyFilter.doFilter() Before.");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("ReqVerifyFilter.doFilter() After.");
    }

    @Override
    public void destroy() {
        LOGGER.info("ReqVerifyFilter.destroy().");
    }
}
