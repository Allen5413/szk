package com.allen.service.teachplan.teachplansubject;

import com.allen.dao.PageInfo;

import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface FindTeachPlanSubjectPageService {
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception;
}
