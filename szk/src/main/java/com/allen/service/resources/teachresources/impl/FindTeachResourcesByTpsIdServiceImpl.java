package com.allen.service.resources.teachresources.impl;

import com.allen.dao.resources.teachresources.TeachResourcesDao;
import com.allen.entity.resources.TeachResources;
import com.allen.service.resources.teachresources.FindTeachResourcesByIdService;
import com.allen.service.resources.teachresources.FindTeachResourcesByTpsIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachResourcesByTpsIdServiceImpl implements FindTeachResourcesByTpsIdService {

    @Resource
    private TeachResourcesDao teachResourcesDao;

    @Override
    public List<TeachResources> find(long tpsId) throws Exception {
        return teachResourcesDao.findByTpsId(tpsId);
    }
}
