package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.AddTeachPlanSubjectService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddTeachPlanSubjectServiceImpl implements AddTeachPlanSubjectService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;

    @Override
    public void add(String loginName, TeachPlanSubject teachPlanSubject) throws Exception {
        TeachPlanSubject teachPlanSubject2 = teachPlanSubjectDao.findByName(teachPlanSubject.getName());
        if(null != teachPlanSubject2 && !StringUtil.isEmpty(teachPlanSubject2.getName())){
            throw new BusinessException("专题名称："+teachPlanSubject.getName()+"，已经存在！");
        }
        teachPlanSubject.setState(TeachPlanSubject.STATE_OPEN);
        teachPlanSubject.setSubjectiveState(TeachPlanSubject.SUBJECTIVESTATE_NOT);
        teachPlanSubject.setObjectiveState(TeachPlanSubject.OBJECTIVESTATE_NOT);
        teachPlanSubject.setResourceState(TeachPlanSubject.RESOURCESTATE_NOT);
        teachPlanSubject.setCreator(loginName);
        teachPlanSubject.setOperator(loginName);
        teachPlanSubjectDao.save(teachPlanSubject);
    }
}
