package xyz.ieden.es.mysql.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import xyz.ieden.es.mysql.entity.EsUserInfo;

import java.util.Optional;

/**
 * @author ThinkPad
 * @date Created by 2018/5/11 10:20
 */
public interface EsUserRepository extends ElasticsearchRepository<EsUserInfo, String> {

    /**
     * 通过 userName 查询 userInfo
     *
     * @param userName
     * @return
     */
    Optional<EsUserInfo> findAllByUserName(String userName);

}
