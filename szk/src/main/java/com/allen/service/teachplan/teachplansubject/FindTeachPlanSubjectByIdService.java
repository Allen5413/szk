package com.allen.service.teachplan.teachplansubject;

import com.allen.entity.teachplan.TeachPlanSubject;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface FindTeachPlanSubjectByIdService {
    public TeachPlanSubject find(long id)throws Exception;
}
