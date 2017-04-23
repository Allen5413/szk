package com.allen.service.resources.objectiveitem;


/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface EditObjectiveItemForStateService {
    public void edit(long id, int state, String loginName)throws Exception;
}
