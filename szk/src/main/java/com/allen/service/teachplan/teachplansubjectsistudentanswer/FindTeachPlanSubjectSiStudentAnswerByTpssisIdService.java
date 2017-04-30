package com.allen.service.teachplan.teachplansubjectsistudentanswer;

import com.allen.entity.teachplan.TeachPlanSubjectSiStudentAnswer;

/**
 * Created by Allen on 2017/4/30 0030.
 */
public interface FindTeachPlanSubjectSiStudentAnswerByTpssisIdService {
    public TeachPlanSubjectSiStudentAnswer find(long tpssisId)throws Exception;
}
