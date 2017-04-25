package com.allen.service.resources.teachresources.impl;

import com.allen.dao.PageInfo;
import com.allen.dao.resources.teachresources.FindTeachResourcesDao;
import com.allen.service.resources.teachresources.FindTeachResourcesPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachResourcesPageServiceImpl implements FindTeachResourcesPageService {

    @Resource
    private FindTeachResourcesDao findTeachResourcesDao;

    @Override
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap) throws Exception {
        return findTeachResourcesDao.findPage(pageInfo, paramsMap, sortMap);
    }
}
