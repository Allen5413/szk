package com.allen.service.resources.objectiveitem.impl;

import com.allen.dao.PageInfo;
import com.allen.dao.resources.objectiveitem.FindObjectiveItemDao;
import com.allen.service.resources.objectiveitem.FindObjectiveItemPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindObjectiveItemPageServiceImpl implements FindObjectiveItemPageService {

    @Resource
    private FindObjectiveItemDao findObjectiveItemDao;

    @Override
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap) throws Exception {
        return findObjectiveItemDao.findPage(pageInfo, paramsMap, sortMap);
    }
}
