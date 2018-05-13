package xyz.ieden.rest.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;
import xyz.ieden.exception.EdenServiceException;
import xyz.ieden.utils.ResultUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@ControllerAdvice
public class ExceptionHandleComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandleComponent.class);

    @ExceptionHandler(value = EdenServiceException.class)
    public void EdenServiceException(HttpServletRequest req, HttpServletResponse resp, EdenServiceException e) {
        try {
            PrintWriter writer = resp.getWriter();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "ERROR");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @ResponseBody
    @ExceptionHandler(EdenException.class)
    public Result<Object> handleEdenException(HttpServletRequest req, HttpServletResponse resp, EdenException e) {
        Result<Object> result = ResultUtils.createResult();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        LOGGER.error(e.getMessage(), e);
        Result<Object> result = ResultUtils.error(e.getMessage());
        return result;
    }
}
