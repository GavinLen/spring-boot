package xyz.ieden.dm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.ieden.dm.entity.SimplePageable;
import xyz.ieden.dm.entity.UserInfo;
import xyz.ieden.dm.repository.IMongoRepository;
import xyz.ieden.dm.service.IMongoService;

import java.util.List;

/**
 * @author ThinkPad
 * @date Created by 2018/5/10 10:50
 */
@Service
public class MongoServiceImpl implements IMongoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoServiceImpl.class);

    @Autowired(required = false)
    private IMongoRepository mongoRepository;


    /**
     * 通过分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Page<UserInfo> qryUserInfoByPage(Integer pageNumber, Integer pageSize) {
        SimplePageable pageable = new SimplePageable();
        pageable.setPageNumber(pageNumber);
        pageable.setPageSize(pageSize);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        pageable.setSort(sort);
        Page<UserInfo> userInfoPage = mongoRepository.findAll(pageable);
        LOGGER.info("Size: [{}].", userInfoPage.getSize());
        return userInfoPage;
    }

    /**
     * 批量插入
     *
     * @param userInfoList
     * @return
     */
    @Override
    public List<UserInfo> saveUserInfoByBatch(List<UserInfo> userInfoList) {
        List<UserInfo> saveUserInfoList = mongoRepository.insert(userInfoList);
        LOGGER.info("Insert UserInfo Size:[{}].", saveUserInfoList.size());
        return saveUserInfoList;
    }

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        UserInfo saveUserInfo = mongoRepository.insert(userInfo);
        LOGGER.info(saveUserInfo.toString());
        return saveUserInfo;
    }

    @Override
    public List<UserInfo> qryUserInfoAll() {
        List<UserInfo> userInfoList = mongoRepository.findAll();
        LOGGER.info("UserInfo Size:[{}]", userInfoList.size());
        return userInfoList;
    }
}
