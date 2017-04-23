package com.allen.service.teachplan.teachplanstudent;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface AddTeachPlanStudentService {
    public void add(String loginName, long teachPlanId, String... studentCodes)throws Exception;
}
