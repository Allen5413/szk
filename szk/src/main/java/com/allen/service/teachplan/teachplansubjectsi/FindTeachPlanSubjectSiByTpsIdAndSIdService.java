package com.allen.service.teachplan.teachplansubjectsi;

import com.allen.entity.teachplan.TeachPlanSubjectSi;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachPlanSubjectSiByTpsIdAndSIdService {
    public TeachPlanSubjectSi find(long tpsId, long sId)throws Exception;
}
