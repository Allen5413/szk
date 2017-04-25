package com.allen.service.resources.teachresources.impl;

import com.allen.dao.resources.teachresources.TeachResourcesDao;
import com.allen.dao.teachplan.teachplansubjectresources.TeachPlanSubjectResourcesDao;
import com.allen.service.resources.teachresources.DelTeachResourcesByIdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class DelTeachResourcesByIdServiceImpl implements DelTeachResourcesByIdService {

    @Resource
    private TeachResourcesDao teachResourcesDao;
    @Resource
    private TeachPlanSubjectResourcesDao teachPlanSubjectResourcesDao;

    @Override
    @Transactional
    public void del(long id) throws Exception {
        //删除该题与专题的关联
        teachPlanSubjectResourcesDao.delByResourcesId(id);
        //删除该题
        teachResourcesDao.delete(id);
    }
}
