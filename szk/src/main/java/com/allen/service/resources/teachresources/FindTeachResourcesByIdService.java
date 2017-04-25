package com.allen.service.resources.teachresources;

import com.allen.entity.resources.TeachResources;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachResourcesByIdService {
    public TeachResources find(long id)throws Exception;
}
