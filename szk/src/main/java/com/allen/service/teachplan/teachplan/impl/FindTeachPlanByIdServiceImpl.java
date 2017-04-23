package com.allen.service.teachplan.teachplan.impl;

import com.allen.dao.teachplan.teachplan.TeachPlanDao;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.FindTeachPlanByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Service
public class FindTeachPlanByIdServiceImpl implements FindTeachPlanByIdService {

    @Resource
    private TeachPlanDao teachPlanDao;

    @Override
    public TeachPlan find(long id) throws Exception {
        return teachPlanDao.findOne(id);
    }
}
