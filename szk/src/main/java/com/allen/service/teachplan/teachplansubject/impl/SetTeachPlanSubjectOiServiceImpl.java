package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.dao.teachplan.teachplansubjectoi.TeachPlanSubjectOiDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.entity.teachplan.TeachPlanSubjectOi;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectOiService;
import com.allen.util.DateUtil;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class SetTeachPlanSubjectOiServiceImpl implements SetTeachPlanSubjectOiService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;
    @Resource
    private TeachPlanSubjectOiDao teachPlanSubjectOiDao;

    @Override
    @Transactional
    public void setOi(long tpsId, String delTpsoiIds, String beginTime, String endTime, String oiIds, String loginName)throws Exception{
        //修改专题的前测开始结束时间，前测状态为已设置
        TeachPlanSubject teachPlanSubject = teachPlanSubjectDao.findOne(tpsId);
        teachPlanSubject.setObjectiveBeginTime(DateUtil.getNowNewTime(beginTime, "yyyy-MM-dd HH:mm"));
        teachPlanSubject.setObjectiveEndTime(DateUtil.getNowNewTime(endTime, "yyyy-MM-dd HH:mm"));
        teachPlanSubject.setObjectiveState(TeachPlanSubject.OBJECTIVESTATE_YES);
        teachPlanSubject.setOperator(loginName);

        //删除关联题目
        if(!StringUtil.isEmpty(delTpsoiIds)){
            for(String delTpsoiId : delTpsoiIds.split(",")){
                teachPlanSubjectOiDao.delete(Long.parseLong(delTpsoiId));
            }
        }

        //新增关联题目
        if(!StringUtil.isEmpty(oiIds)){
            for(String oiId : oiIds.split(",")){

                TeachPlanSubjectOi teachPlanSubjectOi = teachPlanSubjectOiDao.findByTeachPlanSubjectIdAndObjectiveItemId(tpsId, Long.parseLong(oiId));
                if(null != teachPlanSubjectOi){
                    throw new BusinessException("请不要添加重复的题目");
                }
                teachPlanSubjectOi = new TeachPlanSubjectOi();
                teachPlanSubjectOi.setObjectiveItemId(Long.parseLong(oiId));
                teachPlanSubjectOi.setTeachPlanSubjectId(tpsId);
                teachPlanSubjectOi.setOperator(loginName);
                teachPlanSubjectOiDao.save(teachPlanSubjectOi);
            }
        }
    }
}
