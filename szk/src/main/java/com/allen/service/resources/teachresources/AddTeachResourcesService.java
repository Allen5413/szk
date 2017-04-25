package com.allen.service.resources.teachresources;

import com.allen.entity.resources.TeachResources;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface AddTeachResourcesService {
    public void add(TeachResources teachResources, String[] labels, String loginName)throws Exception;
}
