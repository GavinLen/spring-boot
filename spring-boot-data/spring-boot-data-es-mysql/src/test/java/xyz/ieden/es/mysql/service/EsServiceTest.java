package xyz.ieden.es.mysql.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.ieden.es.mysql.entity.EsUserInfo;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 10:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EsServiceTest {

    @Autowired
    private IEsService esService;

    @Test
    public void testFindUserInfoByUserName() {
        String userName = "tom_1";
        EsUserInfo esUserInfo = esService.findUserInfoByUserName(userName);
        System.out.println(esUserInfo.toString());
    }

}
