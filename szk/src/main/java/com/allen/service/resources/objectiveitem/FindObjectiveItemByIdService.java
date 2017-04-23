package com.allen.service.resources.objectiveitem;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindObjectiveItemByIdService {
    public JSONObject find(long id)throws Exception;
}
