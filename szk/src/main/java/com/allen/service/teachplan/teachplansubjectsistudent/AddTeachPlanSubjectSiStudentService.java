package com.allen.service.teachplan.teachplansubjectsistudent;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface AddTeachPlanSubjectSiStudentService {
    public void add(long siId, long tpsId, long beginTime, long endTime, String answer, long studentId, String loginName)throws Exception;
}
