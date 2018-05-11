package xyz.ieden.es.mysql.service;

import xyz.ieden.es.mysql.entity.EsUserInfo;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 10:22
 */
public interface IEsService {

    /**
     * 
     * @param esUserInfo
     * @return
     */
    EsUserInfo saveUserInfo(EsUserInfo esUserInfo);

    /**
     * 通过 userName 查询 userInfo
     *
     * @param userName
     * @return
     */
    EsUserInfo findUserInfoByUserName(String userName);
}
