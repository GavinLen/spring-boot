package xyz.ieden.menu;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author lianghongwei01
 * @date 2018/9/3 17:38
 */
public class MenuUtilsTest {

    private MenuUtils menuUtils;

    @Before
    public void init() {
        menuUtils = new MenuUtils();
    }

    @Test
    public void test() {
        printList(menuUtils.initMenu());
        List<Menu> list = menuUtils.findTree();
        System.out.println("----------------");
        printList(list);
    }

    private void printList(List<Menu> menuList) {
        for (Menu menu : menuList) {
            System.out.println(menu.toString());
        }
    }

}