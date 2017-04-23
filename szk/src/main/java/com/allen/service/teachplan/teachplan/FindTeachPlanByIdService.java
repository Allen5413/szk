package com.allen.service.teachplan.teachplan;

import com.allen.entity.teachplan.TeachPlan;

/**
 * Created by Allen on 2017/4/21 0021.
 */
public interface FindTeachPlanByIdService {
    public TeachPlan find(long id)throws Exception;
}
