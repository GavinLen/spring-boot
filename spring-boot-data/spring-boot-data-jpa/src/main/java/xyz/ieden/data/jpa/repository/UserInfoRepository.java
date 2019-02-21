package xyz.ieden.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ieden.data.jpa.entity.UserInfoEntity;

/**
 * @author lianghongwei01
 * @date 2019/2/21 19:16
 */
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
}
