package xyz.ieden.data.mongo.service;

import org.springframework.data.domain.Page;
import xyz.ieden.data.mongo.entity.UserInfo;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;

import java.util.List;

/**
 * @author Gavin
 * @date 2018.05.12
 */
public interface IUserInfoService {

    /**
     * 通过分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Result<Page<UserInfo>> qryUserInfoByPage(Integer pageNumber, Integer pageSize) throws EdenException;

    /**
     * 批量插入
     *
     * @param userInfoList
     * @return
     */
    Result<List<UserInfo>> saveUserInfoByBatch(List<UserInfo> userInfoList) throws EdenException;

    /**
     * 插入操作
     *
     * @param userInfo
     * @return
     */
    Result<UserInfo> saveUserInfo(UserInfo userInfo) throws EdenException;

    /**
     * 查询所有的 userInfo
     *
     * @return
     */
    Result<List<UserInfo>> qryUserInfoAll() throws EdenException;
}
