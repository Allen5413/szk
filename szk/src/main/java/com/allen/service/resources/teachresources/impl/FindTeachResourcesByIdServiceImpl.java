package com.allen.service.resources.teachresources.impl;

import com.allen.dao.resources.teachresources.TeachResourcesDao;
import com.allen.entity.resources.TeachResources;
import com.allen.service.resources.teachresources.FindTeachResourcesByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachResourcesByIdServiceImpl implements FindTeachResourcesByIdService {

    @Resource
    private TeachResourcesDao teachResourcesDao;

    @Override
    public TeachResources find(long id) throws Exception {
        return teachResourcesDao.findOne(id);
    }
}
