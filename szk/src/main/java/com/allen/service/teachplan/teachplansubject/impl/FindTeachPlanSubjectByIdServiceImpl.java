package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachPlanSubjectByIdServiceImpl implements FindTeachPlanSubjectByIdService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;

    @Override
    public TeachPlanSubject find(long id) throws Exception {
        return teachPlanSubjectDao.findOne(id);
    }
}
