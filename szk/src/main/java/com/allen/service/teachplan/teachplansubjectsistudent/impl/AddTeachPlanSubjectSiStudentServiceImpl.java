package com.allen.service.teachplan.teachplansubjectsistudent.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.subjectiveitemanswer.SubjectiveItemAnswerDao;
import com.allen.dao.teachplan.teachplansubjectsi.TeachPlanSubjectSiDao;
import com.allen.dao.teachplan.teachplansubjectsistudent.TeachPlanSubjectSiStudentDao;
import com.allen.dao.teachplan.teachplansubjectsistudentanswer.TeachPlanSubjectSiStudentAnswerDao;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.entity.teachplan.*;
import com.allen.service.teachplan.teachplansubjectsistudent.AddTeachPlanSubjectSiStudentService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class AddTeachPlanSubjectSiStudentServiceImpl implements AddTeachPlanSubjectSiStudentService {

    @Resource
    private TeachPlanSubjectSiStudentDao teachPlanSubjectSiStudentDao;
    @Resource
    private TeachPlanSubjectSiStudentAnswerDao teachPlanSubjectSiStudentAnswerDao;
    @Resource
    private TeachPlanSubjectSiDao teachPlanSubjectSiDao;
    @Resource
    private SubjectiveItemAnswerDao subjectiveItemAnswerDao;

    @Override
    @Transactional
    public void add(long siId, long tpsId, long beginTime, long endTime, String answerStudent, long studentId, String loginName) throws Exception {
        try {
            if (StringUtil.isEmpty(answerStudent)) {
                throw new BusinessException("请填写您的答案！");
            }
            //查询计划专题与题目的关联
            TeachPlanSubjectSi teachPlanSubjectSi = teachPlanSubjectSiDao.findByTeachPlanSubjectIdAndSubjectiveItemId(tpsId, siId);
            TeachPlanSubjectSiStudent teachPlanSubjectSiStudent = teachPlanSubjectSiStudentDao.findByUserIdAndTpssiId(studentId, teachPlanSubjectSi.getId());
            if (null != teachPlanSubjectSiStudent && 0 < teachPlanSubjectSiStudent.getId()) {
                throw new BusinessException("您已经做过该题，不能重复做题");
            }

            //查询题目的答案
            List<SubjectiveItemAnswer> answerList = subjectiveItemAnswerDao.findBySubjectiveItemId(siId);
            //计算答题时间
            String timeStr = "";
            long temp = endTime - beginTime;
            long minute = temp / (1000 * 60);
            long second = (temp % (1000 * 60)) / (1000);
            timeStr += minute + "分钟";
            timeStr += 0 == second ? "" : second + "秒";

            //记录学生答题结果
            teachPlanSubjectSiStudent = new TeachPlanSubjectSiStudent();
            teachPlanSubjectSiStudent.setTpssiId(teachPlanSubjectSi.getId());
            teachPlanSubjectSiStudent.setTime(temp);
            teachPlanSubjectSiStudent.setTimeStr(timeStr);
            teachPlanSubjectSiStudent.setUserId(studentId);
            teachPlanSubjectSiStudent.setOperator(loginName);
            teachPlanSubjectSiStudent.setAnswer(answerStudent);
            teachPlanSubjectSiStudentDao.save(teachPlanSubjectSiStudent);

            //记录学生答题时，该题的答案选项及学生选项
            for (SubjectiveItemAnswer answer : answerList) {
                TeachPlanSubjectSiStudentAnswer teachPlanSubjectSiStudentAnswer = new TeachPlanSubjectSiStudentAnswer();
                teachPlanSubjectSiStudentAnswer.setTpssisId(teachPlanSubjectSiStudent.getId());
                teachPlanSubjectSiStudentAnswer.setAnswer(answer.getAnswer());
                teachPlanSubjectSiStudentAnswer.setOperator(loginName);
                teachPlanSubjectSiStudentAnswerDao.save(teachPlanSubjectSiStudentAnswer);
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
