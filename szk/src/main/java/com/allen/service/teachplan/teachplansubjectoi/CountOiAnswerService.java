package com.allen.service.teachplan.teachplansubjectoi;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface CountOiAnswerService {
    public List<JSONObject> count(long tpsId)throws Exception;
}
