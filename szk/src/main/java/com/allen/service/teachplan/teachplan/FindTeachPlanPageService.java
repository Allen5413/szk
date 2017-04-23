package com.allen.service.teachplan.teachplan;

import com.allen.dao.PageInfo;

import java.util.Map;

/**
 * Created by Allen on 2017/4/21 0021.
 */
public interface FindTeachPlanPageService {
    public PageInfo find(PageInfo pageInfo, Map<String, String> paramsMap)throws Exception;
}
