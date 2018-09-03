package xyz.ieden.menu;

import java.util.*;

/**
 * @author lianghongwei01
 * @date 2018/9/3 17:22
 */
public class MenuUtils {


    public List<Menu> findTree() {
        Map<String, Object> data = new HashMap<>();
        List<Menu> menuList = initMenu();
        List<Menu> rootMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (Objects.equals(menu.getParentId(), 0)) {
                rootMenuList.add(menu);
            }
        }
        // 根据Menu类的order排序
        Collections.sort(rootMenuList, order());

        for (Menu nav : rootMenuList) {
            /* 获取根节点下的所有子节点 使用getChild方法*/
            List<Menu> childList = getChild(nav.getId(), menuList);
            // //给根节点设置子节点
            nav.setChildren(childList);
        }
        return rootMenuList;
    }

    /**
     * 获取子节点
     *
     * @param id      父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<Menu> getChild(Integer id, List<Menu> allMenu) {
        //子菜单
        List<Menu> childList = new ArrayList<>();
        for (Menu nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (Objects.equals(nav.getParentId(), id)) {
                childList.add(nav);
            }
        }
        //递归
        for (Menu nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        //排序
        Collections.sort(childList, order());
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }

    /**
     * 排序,根据order排序
     *
     * @return
     */
    public Comparator<Menu> order() {
        Comparator<Menu> comparator = new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                if (o1.getOrder() != o2.getOrder()) {
                    return o1.getOrder() - o2.getOrder();
                }
                return 0;
            }
        };
        return comparator;
    }

    public List<Menu> initMenu() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(1, 0, "m1", "", "", 10));
        menuList.add(new Menu(11, 1, "m11", "", "", 10));
        menuList.add(new Menu(12, 1, "m12", "", "", 10));
        menuList.add(new Menu(13, 1, "m13", "", "", 10));
        menuList.add(new Menu(14, 1, "m14", "", "", 10));

        menuList.add(new Menu(2, 0, "m2", "", "", 10));
        menuList.add(new Menu(21, 2, "m21", "", "", 10));
        menuList.add(new Menu(22, 2, "m22", "", "", 10));
        menuList.add(new Menu(23, 2, "m23", "", "", 10));

        menuList.add(new Menu(3, 0, "m3", "", "", 10));
        menuList.add(new Menu(31, 3, "m31", "", "", 10));

        return menuList;
    }
}
