package com.allen.service.resources.objectiveitem.impl;

import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.dao.teachplan.teachplansubjectoi.TeachPlanSubjectOiDao;
import com.allen.dao.teachplan.teachplansubjectoistudent.TeachPlanSubjectOiStudentDao;
import com.allen.dao.teachplan.teachplansubjectoistudentanswer.TeachPlanSubjectOiStudentAnswerDao;
import com.allen.service.resources.objectiveitem.DelObjectiveItemByIdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class DelObjectiveItemByIdServiceImpl implements DelObjectiveItemByIdService {

    @Resource
    private ObjectiveItemDao objectiveItemDao;
    @Resource
    private ObjectiveItemAnswerDao objectiveItemAnswerDao;
    @Resource
    private TeachPlanSubjectOiStudentAnswerDao teachPlanSubjectOiStudentAnswerDao;
    @Resource
    private TeachPlanSubjectOiStudentDao teachPlanSubjectOiStudentDao;
    @Resource
    private TeachPlanSubjectOiDao teachPlanSubjectOiDao;

    @Override
    @Transactional
    public void del(long id) throws Exception {
        //删除该题的学生选择情况
        teachPlanSubjectOiStudentAnswerDao.delByOiId(id);
        //删除该题的学生答题情况
        teachPlanSubjectOiStudentDao.delByOiId(id);
        //删除该题与专题的关联
        teachPlanSubjectOiDao.delByOiId(id);
        //删除该题的答案
        objectiveItemAnswerDao.delByObjectiveItemId(id);
        //删除该题
        objectiveItemDao.delete(id);
    }
}
