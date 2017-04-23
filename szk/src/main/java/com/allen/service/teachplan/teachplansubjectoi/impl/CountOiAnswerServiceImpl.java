package com.allen.service.teachplan.teachplansubjectoi.impl;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.dao.teachplan.teachplanstudent.TeachPlanStudentDao;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.dao.teachplan.teachplansubjectoi.TeachPlanSubjectOiDao;
import com.allen.dao.teachplan.teachplansubjectoistudent.TeachPlanSubjectOiStudentDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.teachplan.TeachPlanStudent;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.entity.teachplan.TeachPlanSubjectOi;
import com.allen.entity.teachplan.TeachPlanSubjectOiStudent;
import com.allen.service.teachplan.teachplansubjectoi.CountOiAnswerService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class CountOiAnswerServiceImpl implements CountOiAnswerService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;
    @Resource
    private TeachPlanSubjectOiDao teachPlanSubjectOiDao;
    @Resource
    private TeachPlanStudentDao teachPlanStudentDao;
    @Resource
    private TeachPlanSubjectOiStudentDao teachPlanSubjectOiStudentDao;
    @Resource
    private ObjectiveItemDao objectiveItemDao;

    @Override
    public List<JSONObject> count(long tpsId) throws Exception {
        List<JSONObject> list = new ArrayList<JSONObject>();
        //查询专题
        TeachPlanSubject teachPlanSubject = teachPlanSubjectDao.findOne(tpsId);
        //查询专题下的题目
        List<TeachPlanSubjectOi> oiList = teachPlanSubjectOiDao.findByTeachPlanSubjectId(tpsId);
        //查询专题下的学生
        List<TeachPlanStudent> studentList = teachPlanStudentDao.findByTeachPlanId(teachPlanSubject.getTeachPlanId());
        if(null != oiList && 0 < oiList.size()){
            int totalStudent = null == studentList ? 0 : studentList.size();
            for(TeachPlanSubjectOi teachPlanSubjectOi : oiList){
                JSONObject json = new JSONObject();
                //查询题目
                ObjectiveItem objectiveItem = objectiveItemDao.findOne(teachPlanSubjectOi.getObjectiveItemId());
                //查询学生答题记录
                List<TeachPlanSubjectOiStudent> studentAnswerList = teachPlanSubjectOiStudentDao.findByTpsoiId(teachPlanSubjectOi.getId());
                //答对的人数
                int rightCount = 0;
                //正确率
                String rightRatio = "";
                //答错的人数
                int errorCount = 0;
                //错误率
                String errorRatio = "";
                //未答的人数
                int notAnswerCount = 0;
                //总耗时
                long totalTime = 0;
                //平均耗时
                String avgTime = "";
                if(null != studentAnswerList && 0 < studentAnswerList.size()){
                    for(TeachPlanSubjectOiStudent teachPlanSubjectOiStudent : studentAnswerList){
                        if(teachPlanSubjectOiStudent.getIsRight() == TeachPlanSubjectOiStudent.ISRIGHT_RIGHT){
                            rightCount++;
                        }else{
                            errorCount++;
                        }
                        totalTime += teachPlanSubjectOiStudent.getTime();
                    }
                    rightRatio = new BigDecimal(rightCount* 100).divide(new BigDecimal(studentAnswerList.size()), 2, BigDecimal.ROUND_HALF_UP).toString();
                    errorRatio = new BigDecimal(100).subtract(new BigDecimal(rightRatio)).toString();

                    long temp = totalTime/studentAnswerList.size();
                    if(0 < temp) {
                        long minute = temp / (1000 * 60);
                        long second = (temp % (1000 * 60)) / (1000);
                        avgTime += minute + "分钟";
                        avgTime += 0 == second ? "" : second + "秒";
                    }else{
                        avgTime = "0秒";
                    }
                }
                notAnswerCount = totalStudent - rightCount - errorCount;

                json.put("name", objectiveItem.getName());
                json.put("tpsoiId", teachPlanSubjectOi.getId());
                json.put("rightCount", rightCount);
                json.put("rightRatio", rightRatio);
                json.put("errorCount", errorCount);
                json.put("errorRatio", errorRatio);
                json.put("notAnswerCount", notAnswerCount);
                json.put("avgTime", avgTime);
                list.add(json);
            }
        }
        return list;
    }
}
