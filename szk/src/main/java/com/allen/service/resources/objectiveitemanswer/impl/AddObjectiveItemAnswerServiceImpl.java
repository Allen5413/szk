package com.allen.service.resources.objectiveitemanswer.impl;

import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.service.resources.objectiveitemanswer.AddObjectiveItemAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddObjectiveItemAnswerServiceImpl implements AddObjectiveItemAnswerService {

    @Resource
    private ObjectiveItemAnswerDao objectiveItemAnswerDao;

    @Override
    public void add(ObjectiveItemAnswer objectiveItemAnswer) throws Exception {
        objectiveItemAnswerDao.save(objectiveItemAnswer);
    }
}
