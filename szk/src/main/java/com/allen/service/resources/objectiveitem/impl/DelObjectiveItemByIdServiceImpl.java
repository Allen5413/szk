package com.allen.service.resources.objectiveitem.impl;

import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.service.resources.objectiveitem.DelObjectiveItemByIdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class DelObjectiveItemByIdServiceImpl implements DelObjectiveItemByIdService {

    @Resource
    private ObjectiveItemDao objectiveItemDao;
    @Resource
    private ObjectiveItemAnswerDao objectiveItemAnswerDao;

    @Override
    @Transactional
    public void del(long id) throws Exception {
        objectiveItemAnswerDao.delByObjectiveItemId(id);
        objectiveItemDao.delete(id);
    }
}
