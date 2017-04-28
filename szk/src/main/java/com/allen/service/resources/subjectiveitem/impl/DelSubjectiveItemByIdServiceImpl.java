package com.allen.service.resources.subjectiveitem.impl;

import com.allen.dao.resources.subjectiveitem.SubjectiveItemDao;
import com.allen.dao.resources.subjectiveitemanswer.SubjectiveItemAnswerDao;
import com.allen.dao.teachplan.teachplansubjectsi.TeachPlanSubjectSiDao;
import com.allen.dao.teachplan.teachplansubjectsistudent.TeachPlanSubjectSiStudentDao;
import com.allen.dao.teachplan.teachplansubjectsistudentanswer.TeachPlanSubjectSiStudentAnswerDao;
import com.allen.service.resources.subjectiveitem.DelSubjectiveItemByIdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class DelSubjectiveItemByIdServiceImpl implements DelSubjectiveItemByIdService {

    @Resource
    private SubjectiveItemDao subjectiveItemDao;
    @Resource
    private SubjectiveItemAnswerDao subjectiveItemAnswerDao;
    @Resource
    private TeachPlanSubjectSiStudentAnswerDao teachPlanSubjectSiStudentAnswerDao;
    @Resource
    private TeachPlanSubjectSiStudentDao teachPlanSubjectSiStudentDao;
    @Resource
    private TeachPlanSubjectSiDao teachPlanSubjectSiDao;

    @Override
    @Transactional
    public void del(long id) throws Exception {
        //删除该题的学生选择情况
        teachPlanSubjectSiStudentAnswerDao.delBySiId(id);
        //删除该题的学生答题情况
        teachPlanSubjectSiStudentDao.delBySiId(id);
        //删除该题与专题的关联
        teachPlanSubjectSiDao.delBySiId(id);
        //删除该题的答案
        subjectiveItemAnswerDao.delBySubjectiveItemId(id);
        //删除该题
        subjectiveItemDao.delete(id);
    }
}
