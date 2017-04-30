package com.allen.service.teachplan.teachplansubjectsistudentanswer.impl;

import com.allen.dao.teachplan.teachplansubjectsistudentanswer.TeachPlanSubjectSiStudentAnswerDao;
import com.allen.entity.teachplan.TeachPlanSubjectSiStudentAnswer;
import com.allen.service.teachplan.teachplansubjectsistudentanswer.FindTeachPlanSubjectSiStudentAnswerByTpssisIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/30 0030.
 */
@Service
public class FindTeachPlanSubjectSiStudentAnswerByTpssisIdServiceImpl implements FindTeachPlanSubjectSiStudentAnswerByTpssisIdService {

    @Resource
    private TeachPlanSubjectSiStudentAnswerDao teachPlanSubjectSiStudentAnswerDao;

    @Override
    public TeachPlanSubjectSiStudentAnswer find(long tpssisId) throws Exception {
        return teachPlanSubjectSiStudentAnswerDao.findByTpssisId(tpssisId);
    }
}
