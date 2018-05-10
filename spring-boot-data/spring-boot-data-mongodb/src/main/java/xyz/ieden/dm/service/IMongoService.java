package xyz.ieden.dm.service;

import org.springframework.data.domain.Page;
import xyz.ieden.dm.entity.UserInfo;

import java.util.List;

/**
 * @author ThinkPad
 * @date Created by 2018/5/10 10:50
 */
public interface IMongoService {

    /**
     * 通过分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<UserInfo> qryUserInfoByPage(Integer pageNumber, Integer pageSize);

    /**
     * 批量插入
     *
     * @param userInfoList
     * @return
     */
    List<UserInfo> saveUserInfoByBatch(List<UserInfo> userInfoList);

    /**
     * 插入操作
     *
     * @param userInfo
     * @return
     */
    UserInfo saveUserInfo(UserInfo userInfo);

    /**
     * 查询所有的 userInfo
     *
     * @return
     */
    List<UserInfo> qryUserInfoAll();

}
