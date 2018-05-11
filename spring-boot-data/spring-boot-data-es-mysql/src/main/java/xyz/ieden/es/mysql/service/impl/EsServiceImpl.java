package xyz.ieden.es.mysql.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ieden.es.mysql.entity.EsUserInfo;
import xyz.ieden.es.mysql.repository.EsUserRepository;
import xyz.ieden.es.mysql.service.IEsService;

import java.util.Optional;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 10:24
 */
@Service
public class EsServiceImpl implements IEsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsServiceImpl.class);

    @Autowired(required = false)
    private EsUserRepository esUserRepository;

    public EsUserInfo saveUserInfo(EsUserInfo esUserInfo) {
        LOGGER.info("Save UserInfo.");
        EsUserInfo saveUserInfo = esUserRepository.index(esUserInfo);
        LOGGER.info("Save UserInfo:[{}].", saveUserInfo.toString());
        return saveUserInfo;
    }

    @Override
    public EsUserInfo findUserInfoByUserName(String userName) {
        LOGGER.info("Query UserInfo By UserName:[{}].", userName);
        Optional<EsUserInfo> optional = esUserRepository.findAllByUserName(userName);
        EsUserInfo esUserInfo = optional.get();
        LOGGER.info("EsUserInfo:[{}]", esUserInfo.toString());
        return esUserInfo;
    }
}
