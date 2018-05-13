package xyz.ieden.data.mongo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.ieden.data.mongo.entity.UserInfo;
import xyz.ieden.entity.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gavin on 2018.05.12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserInfoServiceTest {


    @Autowired
    private IUserInfoService userInfoService;

    @Test
    public void testQryUserInfoByPage() {
        Integer pageNum = 1;
        Integer size = 50;
        Result<Page<UserInfo>> result = userInfoService.qryUserInfoByPage(pageNum, size);
        Page<UserInfo> page = result.getData();
        List<UserInfo> userInfoList = page.getContent();
        System.out.println(page.getNumber());
        printList(userInfoList);
    }

    @Test
    public void testSaveUserInfoByBatch() {
        long startTime = System.currentTimeMillis();
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 10; i < 10010; i++) {
            UserInfo userInfo = new UserInfo("len", "tom_" + i, "123456", i + 10);
            userInfo.setCreateDateTime(new Date());
            userInfoList.add(userInfo);
        }

        Result<List<UserInfo>> result = userInfoService.saveUserInfoByBatch(userInfoList);
        List<UserInfo> saveUserInfoList = result.getData();

        System.out.println("Run Time:" + (System.currentTimeMillis() - startTime));

        System.out.println(saveUserInfoList.size());
        printList(saveUserInfoList);
    }

    @Test
    public void testSaveUserInfo() {

        UserInfo userInfo = new UserInfo("len", "tom_1", "123456", 30);
        Result<UserInfo> result = userInfoService.saveUserInfo(userInfo);
        UserInfo saveUserInfo = result.getData();
        System.out.println(saveUserInfo.toString());

    }

    @Test
    public void testQryUserInfoAll() {
        Result<List<UserInfo>> result = userInfoService.qryUserInfoAll();
        List<UserInfo> userInfoList = result.getData();
        printList(userInfoList);
    }

    /**
     * 输出 UserInfo List
     *
     * @param list
     * @param <T>
     */
    private <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t.toString());
        }
    }
}
