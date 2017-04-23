package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectService;
import com.allen.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Service
public class EditTeachPlanSubjectServiceImpl implements EditTeachPlanSubjectService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;

    public void edit(TeachPlanSubject teachPlanSubject, String loginName)throws Exception{
        TeachPlanSubject oldTeachPlanSubject = teachPlanSubjectDao.findByName(teachPlanSubject.getName());
        if(null != oldTeachPlanSubject && oldTeachPlanSubject.getId() != teachPlanSubject.getId()){
            throw new BusinessException("专题名称已存在！");
        }
        oldTeachPlanSubject = teachPlanSubjectDao.findOne(teachPlanSubject.getId());
        oldTeachPlanSubject.setName(teachPlanSubject.getName());
        oldTeachPlanSubject.setState(teachPlanSubject.getState());
        oldTeachPlanSubject.setSubjectiveState(teachPlanSubject.getSubjectiveState());
        oldTeachPlanSubject.setObjectiveState(teachPlanSubject.getObjectiveState());
        oldTeachPlanSubject.setResourceState(teachPlanSubject.getResourceState());
        oldTeachPlanSubject.setOperator(loginName);
        oldTeachPlanSubject.setOperateTime(DateUtil.getLongNowTime());
        teachPlanSubjectDao.save(oldTeachPlanSubject);
    }
}
