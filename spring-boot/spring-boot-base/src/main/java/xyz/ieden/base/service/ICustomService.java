package xyz.ieden.base.service;

import xyz.ieden.base.config.CustomConfig;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;

/**
 * @author ThinkPad
 * @date Created by 2018/5/15 16:58
 */
public interface ICustomService {

    Result<CustomConfig> qryCustomInfo() throws EdenException;

}
