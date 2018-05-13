package xyz.ieden.data.mongo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.ieden.data.mongo.entity.SimplePageable;
import xyz.ieden.data.mongo.entity.UserInfo;
import xyz.ieden.data.mongo.repository.UserInfoRepository;
import xyz.ieden.data.mongo.service.IUserInfoService;
import xyz.ieden.entity.Result;
import xyz.ieden.exception.EdenException;
import xyz.ieden.utils.ResultUtils;

import java.util.List;

/**
 * @author Gavin
 * @date 2018.05.12
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoRepository userInfoRepository;


    /**
     * 通过分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return
     * @throws EdenException
     */
    @Override
    public Result<Page<UserInfo>> qryUserInfoByPage(Integer pageNumber, Integer pageSize) throws EdenException {
        LOGGER.info("Query UserInfo By Page:pageNumber [{}], pageSize [{}].", pageNumber, pageSize);
        Result<Page<UserInfo>> result = ResultUtils.createResult();

        SimplePageable pageable = new SimplePageable();
        pageable.setPageNumber(pageNumber);
        pageable.setPageSize(pageSize);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        pageable.setSort(sort);
        Page<UserInfo> userInfoPage = userInfoRepository.findAll(pageable);
        LOGGER.info("Query UserInfo Size: [{}].", userInfoPage.getSize());

        result.setData(userInfoPage);

        return result;

    }

    /**
     * 批量插入
     *
     * @param userInfoList
     * @return
     * @throws EdenException
     */
    @Override
    public Result<List<UserInfo>> saveUserInfoByBatch(List<UserInfo> userInfoList) throws EdenException {
        LOGGER.info("Batch Save UserInfo.");
        Result<List<UserInfo>> result = ResultUtils.createResult();

        List<UserInfo> saveUserInfoList = userInfoRepository.saveAll(userInfoList);
        LOGGER.info("Save User Size:[{}].", saveUserInfoList.size());

        result.setData(saveUserInfoList);

        return result;
    }

    /**
     * 插入操作
     *
     * @param userInfo
     * @return
     * @throws EdenException
     */
    @Override
    public Result<UserInfo> saveUserInfo(UserInfo userInfo) throws EdenException {
        LOGGER.info("Save UserInfo.");
        Result<UserInfo> result = ResultUtils.createResult();

        UserInfo saveUserInfo = userInfoRepository.save(userInfo);
        LOGGER.info("Save UserInfo:[{}].", saveUserInfo.toString());

        result.setData(saveUserInfo);

        return result;
    }

    /**
     * 查询所有的 userInfo
     *
     * @return
     * @throws EdenException
     */
    @Override
    public Result<List<UserInfo>> qryUserInfoAll() throws EdenException {
        LOGGER.info("Query All UserInfo.");
        Result<List<UserInfo>> result = ResultUtils.createResult();

        List<UserInfo> userInfoList = userInfoRepository.findAll();
        LOGGER.info("Query UserInfo Size:[{}].", userInfoList.size());

        result.setData(userInfoList);

        return result;
    }
}
