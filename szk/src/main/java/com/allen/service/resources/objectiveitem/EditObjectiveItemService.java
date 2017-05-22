package com.allen.service.resources.objectiveitem;

import com.allen.entity.resources.ObjectiveItem;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface EditObjectiveItemService {
    public void edit(ObjectiveItem objectiveItem, String[] labels, String[] answers, String loginName)throws Exception;
}
