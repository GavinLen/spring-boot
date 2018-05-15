package xyz.ieden.base.service.impl;

import org.springframework.stereotype.Service;
import xyz.ieden.base.config.CustomConfig;
import xyz.ieden.base.service.ICustomService;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 16:59
 */
@Service
public class CustomServiceImpl implements ICustomService {



    @Override
    public Result<CustomConfig> qryCustomInfo() throws EdenException {
        return null;
    }
}
