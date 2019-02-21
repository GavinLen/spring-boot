package xyz.ieden.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ieden.data.jpa.entity.MyFriendEntity;

/**
 * @author lianghongwei01
 * @date 2019/2/21 19:18
 */
public interface MyFriendRepository extends JpaRepository<MyFriendEntity, Integer> {
}
