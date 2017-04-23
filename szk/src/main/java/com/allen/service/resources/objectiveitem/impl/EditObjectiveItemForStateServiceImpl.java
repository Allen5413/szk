package com.allen.service.resources.objectiveitem.impl;

import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.service.resources.objectiveitem.EditObjectiveItemForStateService;
import com.allen.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class EditObjectiveItemForStateServiceImpl implements EditObjectiveItemForStateService {

    @Resource
    private ObjectiveItemDao objectiveItemDao;

    @Override
    public void edit(long id, int state, String loginName) throws Exception {
        ObjectiveItem objectiveItem = objectiveItemDao.findOne(id);
        objectiveItem.setState(state);
        objectiveItem.setOperator(loginName);
        objectiveItem.setOperateTime(DateUtil.getLongNowTime());
        objectiveItemDao.save(objectiveItem);
    }
}
