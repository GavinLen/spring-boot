package xyz.ieden.menu;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @author lianghongwei01
 * @date 2018/9/3 16:46
 */
public class Menu {

    /**
     * 菜单id
     */
    private Integer id;
    /**
     * 父菜单id
     */
    private Integer parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单url
     */
    private String url;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单顺序
     */
    private int order;
    /**
     * 子菜单
     */
    private List<Menu> children;

    public Menu() {
    }

    public Menu(Integer id, Integer parentId, String name, String url, String icon, int order) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
