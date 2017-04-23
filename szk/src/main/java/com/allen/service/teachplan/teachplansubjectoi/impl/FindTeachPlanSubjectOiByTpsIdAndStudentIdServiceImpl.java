package com.allen.service.teachplan.teachplansubjectoi.impl;

import com.allen.dao.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiDao;
import com.allen.service.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiByTpsIdAndStudentIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectOiByTpsIdAndStudentIdServiceImpl implements FindTeachPlanSubjectOiByTpsIdAndStudentIdService {

    @Resource
    private FindTeachPlanSubjectOiDao findTeachPlanSubjectOiDao;

    @Override
    public List<Map> find(long tpsId, long studentId) throws Exception {
        return findTeachPlanSubjectOiDao.findStudentForOi(tpsId, studentId);
    }
}
