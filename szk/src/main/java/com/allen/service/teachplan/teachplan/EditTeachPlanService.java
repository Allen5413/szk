package com.allen.service.teachplan.teachplan;

import com.allen.entity.teachplan.TeachPlan;

/**
 * Created by Allen on 2017/4/21 0021.
 */
public interface EditTeachPlanService {
    public void edit(TeachPlan teachPlan, String loginName)throws Exception;
}
