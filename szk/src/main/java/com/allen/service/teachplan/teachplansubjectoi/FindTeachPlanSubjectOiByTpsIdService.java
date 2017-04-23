package com.allen.service.teachplan.teachplansubjectoi;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachPlanSubjectOiByTpsIdService {
    public List<Map> find(long tpsId)throws Exception;
}
