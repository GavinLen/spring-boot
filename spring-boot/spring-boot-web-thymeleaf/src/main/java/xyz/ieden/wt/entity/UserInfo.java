package xyz.ieden.wt.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lianghongwei01
 * @date 2018/8/3 12:52
 */
@EqualsAndHashCode
@ToString(includeFieldNames = false, exclude = {"createTime"})
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private Long id;
    private String userName;
    private String password;
    private Date createTime;

}
