package xyz.ieden.es.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ieden.es.mysql.entity.EsUserInfo;
import xyz.ieden.es.mysql.service.IEsService;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 10:59
 */
@RestController
public class EsController {

    @Autowired
    private IEsService esService;

    @GetMapping(value = "")
    public EsUserInfo getUserInfo() {
        EsUserInfo esUserInfo = esService.findUserInfoByUserName("tom_1");
        return esUserInfo;
    }
}
