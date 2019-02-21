package xyz.ieden.wt.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.ieden.entity.Result;
import xyz.ieden.utils.ResultUtils;
import xyz.ieden.wt.entity.OptionEntity;
import xyz.ieden.wt.entity.OptionGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lianghongwei01
 * @date 2019/1/22 16:27
 */
@RestController
@RequestMapping(value = "data")
public class DataController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/option/{id}")
    public Result<OptionEntity> getOption(@PathVariable(name = "id") Integer id) {
        LOGGER.info("Get Id {} Option.", id);
        Result<OptionEntity> result = ResultUtils.createResult();
        OptionEntity entity = new OptionEntity(id, "test_" + id);
        result.setData(entity);
        return result;
    }

    @GetMapping(value = "option/group")
    public Result<List<OptionGroup>> getGroupListByText(@RequestParam(value = "type") String typeStr, @RequestParam(value = "search") String queryStr) {
        LOGGER.info("Query Type [{}] Str [{}].", typeStr, queryStr);
        Result<List<OptionGroup>> result = ResultUtils.createResult();

        if (StringUtils.isBlank(queryStr)) {
            return getGroupList();
        }

        List<OptionGroup> groupList = new ArrayList<>();
        List<OptionEntity> entityList = new ArrayList<>(5);
        for (int j = 0; j < 5; j++) {
            OptionEntity entity = new OptionEntity(j, "test_" + j);
            entityList.add(entity);
        }
        OptionGroup group = new OptionGroup(0, "Group_" + queryStr, entityList);
        groupList.add(group);
        result.setData(groupList);
        return result;
    }

    public Result<List<OptionGroup>> getGroupList() {
        Result<List<OptionGroup>> result = ResultUtils.createResult();
        List<OptionGroup> groupList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<OptionEntity> entityList = new ArrayList<>(5);
            for (int j = 0; j < 5; j++) {
                OptionEntity entity = new OptionEntity(j, "test_" + j);
                entityList.add(entity);
            }
            OptionGroup group = new OptionGroup(i, "Group_" + i, entityList);
            groupList.add(group);
        }
        result.setData(groupList);
        return result;

    }

    @GetMapping(value = "option")
    public Result<List<OptionEntity>> getOptionList() {
        Result<List<OptionEntity>> result = ResultUtils.createResult();
        List<OptionEntity> optionEntityList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            OptionEntity entity = new OptionEntity(i, "test_" + i);
            optionEntityList.add(entity);
        }
        LOGGER.info("Option Size:[{}].", optionEntityList.size());
        result.setData(optionEntityList);
        return result;
    }


}
