package xyz.ieden.scheduled;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by Gavin on 2018.05.12.
 */
public class UuidTest {

    @Test
    public void testNameUUIDFromBytes() {
        String name = "中国电信有限公司";
        System.out.println(UUID.nameUUIDFromBytes(name.getBytes()).toString());
        System.out.println(UUID.nameUUIDFromBytes(name.getBytes()).toString());
        System.out.println(UUID.nameUUIDFromBytes(name.getBytes()).toString());
        System.out.println(UUID.nameUUIDFromBytes(name.getBytes()).toString());
    }

}
