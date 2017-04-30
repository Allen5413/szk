package com.allen.service.teachplan.teachplansubjectsistudent;

import com.allen.entity.teachplan.TeachPlanSubjectSiStudent;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService {
    public TeachPlanSubjectSiStudent find(long tpssiId, long studentId)throws Exception;
}
