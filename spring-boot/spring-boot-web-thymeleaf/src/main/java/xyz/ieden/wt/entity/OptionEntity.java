package xyz.ieden.wt.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author lianghongwei01
 * @date 2019/1/22 16:31
 */
public class OptionEntity implements Serializable {
    private Integer id;
    private String text;
    private Boolean selected;
    private Boolean disabled;

    public OptionEntity() {
    }

    public OptionEntity(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    // Getter and Setter Method

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

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(text, ToStringStyle.MULTI_LINE_STYLE);
    }
}
