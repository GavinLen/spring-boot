package xyz.ieden.rest.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenServiceException;
import xyz.ieden.utils.ResultUtils;

import java.util.Date;

/**
 *
 * @author Gavin
 * @date 2018.05.12
 */
@RestController
@RequestMapping(value = "api")
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @GetMapping(value = "ex")
    public Result<JSONObject> exceptionHandle() {
        LOGGER.info("MyController.exceptionHandle()");
        throw new EdenServiceException();
    }

    @GetMapping(value = "get")
    public Result<JSONObject> getReq() {
        LOGGER.info("MyController.getReq()");
        Result<JSONObject> result = ResultUtils.createResult();
        JSONObject respJson = new JSONObject();
        respJson.put("createDate", new Date());
        result.setData(respJson);
        return result;
    }
}
