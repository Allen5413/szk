package com.allen.service.resources.teachresources;

import com.allen.dao.PageInfo;

import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface FindTeachResourcesPageService {

    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception;
}
