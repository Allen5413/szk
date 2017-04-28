package com.allen.service.teachplan.teachplansubjectsistudent.impl;

import com.allen.dao.teachplan.teachplansubjectsistudent.FindTeachPlanSubjectSiStudentDao;
import com.allen.service.teachplan.teachplansubjectsistudent.FindTeachPlanSubjectSiStudentByTpssiIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectSiStudentByTpssiIdServiceImpl implements FindTeachPlanSubjectSiStudentByTpssiIdService {

    @Resource
    private FindTeachPlanSubjectSiStudentDao findTeachPlanSubjectSiStudentDao;

    @Override
    public List<Map> find(long tpssiId) throws Exception {
        return findTeachPlanSubjectSiStudentDao.findByTpssiId(tpssiId);
    }
}
