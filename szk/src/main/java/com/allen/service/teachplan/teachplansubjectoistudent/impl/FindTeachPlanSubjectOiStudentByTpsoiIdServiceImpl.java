package com.allen.service.teachplan.teachplansubjectoistudent.impl;

import com.allen.dao.teachplan.teachplansubjectoistudent.FindTeachPlanSubjectOiStudentDao;
import com.allen.service.teachplan.teachplansubjectoistudent.FindTeachPlanSubjectOiStudentByTpsoiIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectOiStudentByTpsoiIdServiceImpl implements FindTeachPlanSubjectOiStudentByTpsoiIdService {

    @Resource
    private FindTeachPlanSubjectOiStudentDao findTeachPlanSubjectOiStudentDao;

    @Override
    public List<Map> find(long tpsoiId) throws Exception {
        return findTeachPlanSubjectOiStudentDao.findByTpsoiId(tpsoiId);
    }
}
