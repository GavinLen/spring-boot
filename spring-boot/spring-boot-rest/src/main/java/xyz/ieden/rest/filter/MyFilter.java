package xyz.ieden.rest.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * @author Gavin
 * @date 2018.05.12
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*", description = "自定义的过滤器")
public class MyFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("MyFilter.init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("MyFilter.doFilter() Before.");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("MyFilter.doFilter() After.");
    }

    @Override
    public void destroy() {
        LOGGER.info("MyFilter.destroy()");
    }
}
