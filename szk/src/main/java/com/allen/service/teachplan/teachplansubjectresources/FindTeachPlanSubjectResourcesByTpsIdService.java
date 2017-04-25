package com.allen.service.teachplan.teachplansubjectresources;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachPlanSubjectResourcesByTpsIdService {
    public List<Map> find(long tpsId)throws Exception;
}
