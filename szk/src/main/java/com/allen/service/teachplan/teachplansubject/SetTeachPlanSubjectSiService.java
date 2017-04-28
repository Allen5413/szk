package com.allen.service.teachplan.teachplansubject;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface SetTeachPlanSubjectSiService {
    public void setSi(long tpsId, String delTpssiIds, String beginTime, String endTime, String siIds, String loginName)throws Exception;
}
