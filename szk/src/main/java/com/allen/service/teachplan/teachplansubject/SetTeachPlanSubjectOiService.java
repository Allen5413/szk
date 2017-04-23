package com.allen.service.teachplan.teachplansubject;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface SetTeachPlanSubjectOiService {
    public void setOi(long tpsId, String delTpsoiIds, String beginTime, String endTime, String oiIds, String loginName)throws Exception;
}
