package com.allen.service.resources.teachresources;

import com.allen.entity.resources.TeachResources;

import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachResourcesByTpsIdService {
    public List<TeachResources> find(long tpsId)throws Exception;
}
