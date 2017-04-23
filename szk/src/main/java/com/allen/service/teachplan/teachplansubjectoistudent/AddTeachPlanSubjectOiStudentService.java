package com.allen.service.teachplan.teachplansubjectoistudent;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface AddTeachPlanSubjectOiStudentService {
    public boolean add(long oiId, long tpsId, long beginTime, long endTime, String changeAnwserIds, long studentId, String loginName)throws Exception;
}
