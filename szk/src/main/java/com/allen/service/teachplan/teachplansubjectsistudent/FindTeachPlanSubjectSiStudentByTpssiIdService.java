package com.allen.service.teachplan.teachplansubjectsistudent;

import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface FindTeachPlanSubjectSiStudentByTpssiIdService {
    public List<Map> find(long tpssiId)throws Exception;
}
