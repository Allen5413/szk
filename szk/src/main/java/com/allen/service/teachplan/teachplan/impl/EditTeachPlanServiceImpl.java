package com.allen.service.teachplan.teachplan.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplan.TeachPlanDao;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.EditTeachPlanService;
import com.allen.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2016/12/22 0022.
 */
@Service
public class EditTeachPlanServiceImpl implements EditTeachPlanService {

    @Resource
    private TeachPlanDao teachPlanDao;
    @Override
    public void edit(TeachPlan teachPlan, String loginName) throws Exception {
        TeachPlan oldTeachPlan = teachPlanDao.findByName(teachPlan.getName());
        if(null != oldTeachPlan && oldTeachPlan.getId() != teachPlan.getId()){
            throw new BusinessException("计划名称已存在！");
        }
        oldTeachPlan = teachPlanDao.findOne(teachPlan.getId());
        oldTeachPlan.setName(teachPlan.getName());
        oldTeachPlan.setZz(teachPlan.getZz());
        oldTeachPlan.setDetail(teachPlan.getDetail());
        oldTeachPlan.setOperator(loginName);
        oldTeachPlan.setOperateTime(DateUtil.getLongNowTime());
        teachPlanDao.save(oldTeachPlan);
    }
}
