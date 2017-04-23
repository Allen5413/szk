package com.allen.service.teachplan.teachplanstudent.impl;

import com.allen.dao.teachplan.teachplanstudent.TeachPlanStudentDao;
import com.allen.service.teachplan.teachplanstudent.DelTeachPlanStudentByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class DelTeachPlanStudentByIdServiceImpl implements DelTeachPlanStudentByIdService {

    @Resource
    private TeachPlanStudentDao teachPlanStudentDao;

    @Override
    public void del(long id) throws Exception {
        teachPlanStudentDao.delete(id);
    }
}
