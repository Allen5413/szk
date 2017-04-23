package com.allen.service.teachplan.teachplanstudent.impl;

import com.allen.dao.teachplan.teachplanstudent.TeachPlanStudentDao;
import com.allen.dao.user.user.UserDao;
import com.allen.entity.teachplan.TeachPlanStudent;
import com.allen.entity.user.User;
import com.allen.service.teachplan.teachplanstudent.AddTeachPlanStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddTeachPlanStudentServiceImpl implements AddTeachPlanStudentService {

    @Resource
    private TeachPlanStudentDao teachPlanStudentDao;
    @Resource
    private UserDao userDao;

    @Override
    public void add(String loginName, long teachPlanId, String... studentCodes) throws Exception {
        for(String studentCode : studentCodes){
            User user = userDao.findByStudentCode(studentCode);
            if(null != user) {
                TeachPlanStudent teachPlanStudent = new TeachPlanStudent();
                teachPlanStudent.setTeachPlanId(teachPlanId);
                teachPlanStudent.setUserId(user.getId());
                teachPlanStudent.setOperator(loginName);
                teachPlanStudentDao.save(teachPlanStudent);
            }
        }
    }
}
