package xyz.ieden.es.mysql.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.ieden.es.mysql.entity.EsUserInfo;

import java.util.*;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 11:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EsUserRepositoryTest {

    @Autowired
    private EsUserRepository esUserRepository;

    @Test
    public void testSaveByBatch() {
        List<EsUserInfo> list = new ArrayList<>();
        for (int i = 10; i < 10010; i++) {
            String userName = "tom_" + i;
            EsUserInfo esUserInfo = new EsUserInfo(String.valueOf(i), userName, "123456",i,  userName + "@123.com", 1);
            esUserInfo.setCreateTime(new Date());
            esUserInfo.setUpdateTme(new Date());
        }
        Iterable<EsUserInfo> iterable = esUserRepository.saveAll(list);
        print(iterable);

    }

    @Test
    public void testSave() {
        String userName = "tom_" + 10;
        EsUserInfo esUserInfo = new EsUserInfo("10", userName, "123456", 10, userName + "@123.com", 1);
        EsUserInfo save = esUserRepository.save(esUserInfo);
        esUserInfo.setCreateTime(new Date());
        esUserInfo.setUpdateTme(new Date());
        System.out.println(save.toString());
    }

    @Test
    public void testSearch() {
        String id = "10";
        Optional<EsUserInfo> optional = esUserRepository.findById(id);
        EsUserInfo esUserInfo = optional.get();
        System.out.println(esUserInfo.toString());
    }

    private <T> void print(Iterable<T> iterable) {
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
