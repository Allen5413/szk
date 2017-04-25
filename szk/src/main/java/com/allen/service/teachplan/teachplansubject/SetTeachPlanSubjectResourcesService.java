package com.allen.service.teachplan.teachplansubject;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface SetTeachPlanSubjectResourcesService {
    public void setResources(long tpsId, String delTpsrIds, String beginTime, String endTime, String resourcesIds, String loginName)throws Exception;
}
