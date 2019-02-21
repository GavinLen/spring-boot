package xyz.ieden.data.jpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lianghongwei01
 * @date 2019/2/21 19:17
 */
@Entity
@Table(name = "my_friend")
public class MyFriendEntity {

    @EmbeddedId
    private MyFriendEntityId myFriendEntityId;

    https://blog.csdn.net/a842699897/article/details/82377614
    https://shardingsphere.apache.org/document/current/cn/overview/
}
