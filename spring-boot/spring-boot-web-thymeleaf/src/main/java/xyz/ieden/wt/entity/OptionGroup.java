package xyz.ieden.wt.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * @author lianghongwei01
 * @date 2019/1/23 16:51
 */
public class OptionGroup implements Serializable {

    private Integer id;
    private String text;
    private List<OptionEntity> children;

    public OptionGroup(Integer id, String text, List<OptionEntity> children) {
        this.id = id;
        this.text = text;
        this.children = children;
    }

    // Setter and Getter Method

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<OptionEntity> getChildren() {
        return children;
    }

    public void setChildren(List<OptionEntity> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
