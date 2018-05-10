package xyz.ieden.dm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.ieden.dm.entity.UserInfo;

/**
 * @author ThinkPad
 * @date Created by 2018/5/10 9:49
 */
public interface IMongoRepository extends MongoRepository<UserInfo, String> {

    /**
     * 通过 id 和 username 进行模糊匹配
     *
     * @param id
     * @param name
     * @param pageable
     * @return
     */
    // Page<UserInfo> findByIdAnAndUsernameLike(String id, String name, Pageable pageable);

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    @Override
    Page<UserInfo> findAll(Pageable pageable);
}
