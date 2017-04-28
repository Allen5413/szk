package com.allen.service.teachplan.teachplansubjectsi.impl;

import com.allen.dao.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiDao;
import com.allen.service.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiByTpsIdAndStudentIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectSiByTpsIdAndStudentIdServiceImpl implements FindTeachPlanSubjectSiByTpsIdAndStudentIdService {

    @Resource
    private FindTeachPlanSubjectSiDao findTeachPlanSubjectSiDao;

    @Override
    public List<Map> find(long tpsId, long studentId) throws Exception {
        return findTeachPlanSubjectSiDao.findStudentForSi(tpsId, studentId);
    }
}
