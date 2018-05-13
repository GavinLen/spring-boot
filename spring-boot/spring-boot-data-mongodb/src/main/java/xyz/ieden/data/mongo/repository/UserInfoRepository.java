package xyz.ieden.data.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.ieden.data.mongo.entity.UserInfo;

/**
 * @author Gavin
 * @date 2018.05.12
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
}
