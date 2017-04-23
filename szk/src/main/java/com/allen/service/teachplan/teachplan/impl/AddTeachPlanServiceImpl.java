package com.allen.service.teachplan.teachplan.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplan.TeachPlanDao;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.AddTeachPlanService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Service
public class AddTeachPlanServiceImpl implements AddTeachPlanService {

    @Resource
    private TeachPlanDao teachPlanDao;

    @Override
    public void add(TeachPlan teachPlan, String loginName) throws Exception {
        TeachPlan teachPlan2 = teachPlanDao.findByName(teachPlan.getName());
        if(null != teachPlan2 && !StringUtil.isEmpty(teachPlan2.getName())){
            throw new BusinessException("计划名称："+teachPlan.getName()+"，已经存在！");
        }
        teachPlan.setState(TeachPlan.STATE_DOING);
        teachPlan.setCreator(loginName);
        teachPlan.setOperator(loginName);
        teachPlanDao.save(teachPlan);
    }
}
