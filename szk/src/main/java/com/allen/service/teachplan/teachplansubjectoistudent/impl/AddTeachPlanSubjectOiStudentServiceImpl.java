package com.allen.service.teachplan.teachplansubjectoistudent.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.dao.teachplan.teachplansubjectoi.TeachPlanSubjectOiDao;
import com.allen.dao.teachplan.teachplansubjectoistudent.TeachPlanSubjectOiStudentDao;
import com.allen.dao.teachplan.teachplansubjectoistudentanswer.TeachPlanSubjectOiStudentAnswerDao;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.entity.teachplan.TeachPlanSubjectOi;
import com.allen.entity.teachplan.TeachPlanSubjectOiStudent;
import com.allen.entity.teachplan.TeachPlanSubjectOiStudentAnswer;
import com.allen.service.teachplan.teachplansubjectoistudent.AddTeachPlanSubjectOiStudentService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class AddTeachPlanSubjectOiStudentServiceImpl implements AddTeachPlanSubjectOiStudentService {

    @Resource
    private TeachPlanSubjectOiStudentDao teachPlanSubjectOiStudentDao;
    @Resource
    private TeachPlanSubjectOiStudentAnswerDao teachPlanSubjectOiStudentAnswerDao;
    @Resource
    private TeachPlanSubjectOiDao teachPlanSubjectOiDao;
    @Resource
    private ObjectiveItemAnswerDao objectiveItemAnswerDao;

    @Override
    @Transactional
    public boolean add(long oiId, long tpsId, long beginTime, long endTime, String changeAnwserIds, long studentId, String loginName) throws Exception {
        if(StringUtil.isEmpty(changeAnwserIds)){
            throw new BusinessException("请选择答案！");
        }
        //查询计划专题与题目的关联
        TeachPlanSubjectOi teachPlanSubjectOi = teachPlanSubjectOiDao.findByTeachPlanSubjectIdAndObjectiveItemId(tpsId, oiId);
        TeachPlanSubjectOiStudent teachPlanSubjectOiStudent = teachPlanSubjectOiStudentDao.findByUserIdAndTpsoiId(studentId, teachPlanSubjectOi.getId());
        if(null != teachPlanSubjectOiStudent && 0 < teachPlanSubjectOiStudent.getId()){
            throw new BusinessException("您已经做过该题，不能重复做题");
        }

        //查询题目的答案
        List<ObjectiveItemAnswer> answerList = objectiveItemAnswerDao.findByObjectiveItemId(oiId);
        //计算学生是否回答正确
        boolean isRight = this.isRight(answerList, changeAnwserIds);
        //计算答题时间
        String timeStr = "";
        long temp = endTime - beginTime;
        long minute = temp / (1000 * 60);
        long second = (temp % (1000 * 60)) / (1000);
        timeStr += minute+"分钟";
        timeStr += 0 == second ? "" : second+"秒";

        //记录学生答题结果
        teachPlanSubjectOiStudent = new TeachPlanSubjectOiStudent();
        teachPlanSubjectOiStudent.setTpsoiId(teachPlanSubjectOi.getId());
        teachPlanSubjectOiStudent.setTime(temp);
        teachPlanSubjectOiStudent.setTimeStr(timeStr);
        teachPlanSubjectOiStudent.setUserId(studentId);
        teachPlanSubjectOiStudent.setOperator(loginName);
        teachPlanSubjectOiStudent.setIsRight(isRight ? TeachPlanSubjectOiStudent.ISRIGHT_RIGHT : TeachPlanSubjectOiStudent.ISRIGHT_ERROR);
        teachPlanSubjectOiStudentDao.save(teachPlanSubjectOiStudent);

        //记录学生答题时，该题的答案选项及学生选项
        for(ObjectiveItemAnswer answer : answerList){
            TeachPlanSubjectOiStudentAnswer teachPlanSubjectOiStudentAnswer = new TeachPlanSubjectOiStudentAnswer();
            teachPlanSubjectOiStudentAnswer.setTpsoisId(teachPlanSubjectOiStudent.getId());
            teachPlanSubjectOiStudentAnswer.setAnswer(answer.getAnswer());
            teachPlanSubjectOiStudentAnswer.setIsAnswer(answer.getIsAnswer());

            boolean isChange = false;
            for(String changeAnwser : changeAnwserIds.split(",")){
                if(answer.getId() == Long.parseLong(changeAnwser)){
                    isChange = true;
                    break;
                }
            }

            teachPlanSubjectOiStudentAnswer.setIsStudentChange(isChange ? TeachPlanSubjectOiStudentAnswer.ISSTUDENTCHANGE_YES : TeachPlanSubjectOiStudentAnswer.ISSTUDENTCHANGE_NOT);
            teachPlanSubjectOiStudentAnswer.setOperator(loginName);
            teachPlanSubjectOiStudentAnswerDao.save(teachPlanSubjectOiStudentAnswer);
        }
        return isRight;
    }

    private boolean isRight(List<ObjectiveItemAnswer> answerList, String changeAnwserIds)throws Exception{
        boolean result = false;
        String[] changeAnwserArray = changeAnwserIds.split(",");
        if(null != answerList && 0 < answerList.size()){
            //检查是否所有的正确答案都被选中了
            boolean isAnswerForChange = true;
            for(ObjectiveItemAnswer answer : answerList){
                if(answer.getIsAnswer() == ObjectiveItemAnswer.ISANSWER_YES){
                    boolean isChange = false;
                    for(String changeAnwser : changeAnwserArray){
                        if(answer.getId() == Long.parseLong(changeAnwser)){
                            isChange = true;
                            break;
                        }
                    }
                    if(!isChange){
                        isAnswerForChange = false;
                        break;
                    }
                }
            }

            //检查是否选中的答案都是正确答案
            boolean isChangeForAnswer = true;
            for(String changeAnwser : changeAnwserArray){
                boolean isChange = false;
                for(ObjectiveItemAnswer answer : answerList){
                    if(answer.getId() == Long.parseLong(changeAnwser) && answer.getIsAnswer() == ObjectiveItemAnswer.ISANSWER_YES){
                        isChange = true;
                        break;
                    }
                }
                if(!isChange){
                    isChangeForAnswer = false;
                    break;
                }
            }
            //如果2次验证都正确，说明该题回答正确
            if(isAnswerForChange && isChangeForAnswer){
                result =  true;
            }
        }
        return result;
    }
}
