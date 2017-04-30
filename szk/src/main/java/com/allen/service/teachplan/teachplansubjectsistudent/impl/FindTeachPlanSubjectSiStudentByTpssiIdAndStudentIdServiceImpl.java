package com.allen.service.teachplan.teachplansubjectsistudent.impl;

import com.allen.dao.teachplan.teachplansubjectsistudent.TeachPlanSubjectSiStudentDao;
import com.allen.entity.teachplan.TeachPlanSubjectSiStudent;
import com.allen.service.teachplan.teachplansubjectsistudent.FindTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/30 0030.
 */
@Service
public class FindTeachPlanSubjectSiStudentByTpssiIdAndStudentIdServiceImpl implements FindTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService {

    @Resource
    private TeachPlanSubjectSiStudentDao teachPlanSubjectSiStudentDao;

    @Override
    public TeachPlanSubjectSiStudent find(long tpssiId, long studentId) throws Exception {
        return teachPlanSubjectSiStudentDao.findByUserIdAndTpssiId(studentId, tpssiId);
    }
}
