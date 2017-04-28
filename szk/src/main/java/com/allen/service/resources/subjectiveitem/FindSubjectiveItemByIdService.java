package com.allen.service.resources.subjectiveitem;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindSubjectiveItemByIdService {
    public JSONObject find(long id)throws Exception;
}
