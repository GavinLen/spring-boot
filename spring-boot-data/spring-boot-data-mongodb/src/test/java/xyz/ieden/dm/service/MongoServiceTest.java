package xyz.ieden.dm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.ieden.dm.entity.UserInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ThinkPad
 * @date Created by 2018/5/10 13:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongoServiceTest {

    @Autowired
    private IMongoService mongoService;

    @Test
    public void testQryUserInfoByPage() {
        Integer pageNum = 1;
        Integer size = 50;
        Page<UserInfo> page = mongoService.qryUserInfoByPage(pageNum, size);
        List<UserInfo> userInfos = page.getContent();
        System.out.println(page.getNumber());
        printList(userInfos);
    }

    @Test
    public void testSaveUserInfoByBatch() {
        long startTime = System.currentTimeMillis();
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 10; i < 10010; i++) {
            UserInfo userInfo = new UserInfo("tom_" + i, "123456", i + 10);
            userInfo.setCreateTime(new Date());
            userInfoList.add(userInfo);
        }
        List<UserInfo> saveUserInfoList = mongoService.saveUserInfoByBatch(userInfoList);
        System.out.println("Run Time:" + (System.currentTimeMillis() - startTime));
        System.out.println(saveUserInfoList.size());
//        printList(saveUserInfoList);
    }

    @Test
    public void testSaveUserInfo() {
        UserInfo userInfo = new UserInfo("tom_3", "123456", 30);
        userInfo.setCreateTime(new Date());
        UserInfo saveUserInfo = mongoService.saveUserInfo(userInfo);
        System.out.println(saveUserInfo.toString());
    }

    @Test
    public void testQryUserInfoAll() {
        List<UserInfo> userInfoList = mongoService.qryUserInfoAll();
        printList(userInfoList);
    }

    private <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t.toString());
        }
    }

}
