package com.allen.service.teachplan.teachplansubject;

import com.allen.entity.teachplan.TeachPlanSubject;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface AddTeachPlanSubjectService {
    public void add(String loginName, TeachPlanSubject teachPlanSubject)throws Exception;
}
