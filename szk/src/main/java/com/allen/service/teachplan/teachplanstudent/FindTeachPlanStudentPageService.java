package com.allen.service.teachplan.teachplanstudent;

import com.allen.dao.PageInfo;

import java.util.Map;

/**
 * Created by Allen on 2017/4/21 0021.
 */
public interface FindTeachPlanStudentPageService {
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception;
}
