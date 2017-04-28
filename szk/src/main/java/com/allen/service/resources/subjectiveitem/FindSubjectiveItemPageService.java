package com.allen.service.resources.subjectiveitem;

import com.allen.dao.PageInfo;

import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface FindSubjectiveItemPageService {

    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception;
}
