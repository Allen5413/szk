package com.allen.service.teachplan.teachplan.impl;

import com.allen.dao.teachplan.teachplan.TeachPlanDao;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplan.CloseTeachPlanSerivce;
import com.allen.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Allen on 2017/9/28.
 */
@Service
public class CloseTeachPlanSerivceImpl implements CloseTeachPlanSerivce {

    @Autowired
    private TeachPlanDao teachPlanDao;
    @Autowired
    private TeachPlanSubjectDao teachPlanSubjectDao;

    @Override
    public void colseAll() throws Exception {
        String nowDate = DateUtil.getShortNowTime().toString();
        //查询还未关闭的教学计划
        List<TeachPlan> teachPlanList = teachPlanDao.findByState(TeachPlan.STATE_DOING);
        if(null != teachPlanList && 0 < teachPlanList.size()){
            for(TeachPlan teachPlan : teachPlanList){
                //查询教学计划下的专题
                List<TeachPlanSubject> teachPlanSubjectList = teachPlanSubjectDao.findByTeachPlanId(teachPlan.getId());
                if(null != teachPlanSubjectList && 0 < teachPlanSubjectList.size()){
                    int state = TeachPlan.STATE_END;
                    for(TeachPlanSubject teachPlanSubject : teachPlanSubjectList){
                        Date objectiveEndTime = teachPlanSubject.getObjectiveEndTime();
                        Date resourceEndTime = teachPlanSubject.getResourceEndTime();
                        Date subjectiveEndTime = teachPlanSubject.getSubjectiveEndTime();
                        int state2 = TeachPlanSubject.STATE_CLOSE;
                        if(null != objectiveEndTime){
                            if(0 >= DateUtil.compareDate(nowDate, DateUtil.getFormattedString(objectiveEndTime, DateUtil.longDatePattern))){
                                state = TeachPlan.STATE_DOING;
                                state2 = TeachPlanSubject.STATE_OPEN;
                            }
                        }
                        if(null != resourceEndTime){
                            if(0 >= DateUtil.compareDate(nowDate, DateUtil.getFormattedString(resourceEndTime, DateUtil.longDatePattern))){
                                state = TeachPlan.STATE_DOING;
                                state2 = TeachPlanSubject.STATE_OPEN;
                            }
                        }
                        if(null != subjectiveEndTime){
                            if(0 >= DateUtil.compareDate(nowDate, DateUtil.getFormattedString(subjectiveEndTime, DateUtil.longDatePattern))){
                                state = TeachPlan.STATE_DOING;
                                state2 = TeachPlanSubject.STATE_OPEN;
                            }
                        }
                        if(null == objectiveEndTime && null == resourceEndTime && null == subjectiveEndTime){
                            state = TeachPlan.STATE_DOING;
                            state2 = TeachPlanSubject.STATE_OPEN;
                        }
                        if(state2 == TeachPlanSubject.STATE_CLOSE){
                            teachPlanSubject.setState(TeachPlanSubject.STATE_CLOSE);
                            teachPlanSubjectDao.save(teachPlanSubject);
                        }
                    }
                    if(state == TeachPlan.STATE_END){
                        teachPlan.setState(TeachPlan.STATE_END);
                        teachPlanDao.save(teachPlan);
                    }
                }
            }
        }
    }
}
