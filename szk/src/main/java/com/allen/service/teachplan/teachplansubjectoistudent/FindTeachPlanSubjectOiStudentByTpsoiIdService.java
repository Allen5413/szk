package com.allen.service.teachplan.teachplansubjectoistudent;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachPlanSubjectOiStudentByTpsoiIdService {
    public List<Map> find(long tpsoiId)throws Exception;
}
