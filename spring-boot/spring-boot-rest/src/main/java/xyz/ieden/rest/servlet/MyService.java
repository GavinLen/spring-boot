package xyz.ieden.rest.servlet;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import xyz.ieden.entity.Result;
import xyz.ieden.utils.ResultUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@WebServlet(urlPatterns = "/my", description = "自定义的 Servlet")
public class MyService extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String remoteAddr = req.getRemoteAddr();
        String localAddr = req.getLocalAddr();
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        LOGGER.info("remoteAddr:[{}], localAddr:[{}], requestURI:[{}], requestURL[{}].", remoteAddr, localAddr, requestURI, requestURL.toString());
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        Result<Date> result = ResultUtils.createResult();
        result.setData(new Date());
        String jsonString = JSONObject.toJSONString(result);
        PrintWriter writer = resp.getWriter();
        writer.append(jsonString);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        LOGGER.info("MyService.init()");
        super.init();
    }

    @Override
    public void destroy() {
        LOGGER.info("MyService.destroy()");
        super.destroy();
    }
}
