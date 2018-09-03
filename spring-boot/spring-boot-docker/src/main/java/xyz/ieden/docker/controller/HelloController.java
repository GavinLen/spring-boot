package xyz.ieden.docker.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ieden.entity.Result;
import xyz.ieden.utils.ResultUtils;

import java.util.Date;

/**
 * @author lianghongwei01
 * @date 2018/8/2 10:33
 */
@RestController
@RequestMapping(value = "hello")
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<JSONObject> getHello() {
        LOGGER.info("HelloController.getHello()");
        Result<JSONObject> result = ResultUtils.createResult();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("createTime", new Date());
        result.setData(jsonObject);
        return result;
    }

}
