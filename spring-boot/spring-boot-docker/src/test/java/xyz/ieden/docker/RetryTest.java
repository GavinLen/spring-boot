package xyz.ieden.docker;

import org.junit.Test;

/**
 * @author lianghongwei01
 * @date 2018/8/2 19:21
 */
public class RetryTest {

    @Test
    public void test() {
        int count = 0;
        retry:
        for (; ; ) {
//            count = 0;
            for (; ; ) {
                count++;
                System.out.println("count==" + count);
                if (count % 5 == 0) {
                    continue retry;
                }
            }
        }
    }
//    https://blog.csdn.net/paul_wei2008/article/details/53871442
}
