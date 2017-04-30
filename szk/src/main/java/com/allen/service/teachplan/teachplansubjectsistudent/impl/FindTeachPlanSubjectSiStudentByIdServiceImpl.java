package com.allen.service.teachplan.teachplansubjectsistudent.impl;

import com.allen.dao.teachplan.teachplansubjectsistudent.TeachPlanSubjectSiStudentDao;
import com.allen.entity.teachplan.TeachPlanSubjectSiStudent;
import com.allen.service.teachplan.teachplansubjectsistudent.FindTeachPlanSubjectSiStudentByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/5/1 0001.
 */
@Service
public class FindTeachPlanSubjectSiStudentByIdServiceImpl implements FindTeachPlanSubjectSiStudentByIdService {

    @Resource
    private TeachPlanSubjectSiStudentDao teachPlanSubjectSiStudentDao;

    @Override
    public TeachPlanSubjectSiStudent find(long id) throws Exception {
        return teachPlanSubjectSiStudentDao.findOne(id);
    }
}
