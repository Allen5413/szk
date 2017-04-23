package com.allen.service.resources.objectiveitem.impl;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.service.resources.objectiveitem.FindObjectiveItemByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindObjectiveItemByIdServiceImpl implements FindObjectiveItemByIdService {

    @Resource
    private ObjectiveItemDao objectiveItemDao;
    @Resource
    private ObjectiveItemAnswerDao objectiveItemAnswerDao;

    @Override
    public JSONObject find(long id) throws Exception {
        JSONObject json = new JSONObject();
        ObjectiveItem objectiveItem = objectiveItemDao.findOne(id);
        List<ObjectiveItemAnswer> oiaList = objectiveItemAnswerDao.findByObjectiveItemId(id);
        json.put("objectiveItem", objectiveItem);
        json.put("oiaList", oiaList);
        return json;
    }
}
