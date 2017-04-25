package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.dao.teachplan.teachplansubjectresources.TeachPlanSubjectResourcesDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.entity.teachplan.TeachPlanSubjectResources;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectResourcesService;
import com.allen.util.DateUtil;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class SetTeachPlanSubjectResourcesServiceImpl implements SetTeachPlanSubjectResourcesService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;
    @Resource
    private TeachPlanSubjectResourcesDao teachPlanSubjectResourcesDao;

    @Override
    @Transactional
    public void setResources(long tpsId, String delTpsrIds, String beginTime, String endTime, String resourcesIds, String loginName)throws Exception{
        //修改专题的课堂讨论开始结束时间，课堂讨论状态为已设置
        TeachPlanSubject teachPlanSubject = teachPlanSubjectDao.findOne(tpsId);
        teachPlanSubject.setResourceBeginTime(DateUtil.getNowNewTime(beginTime, "yyyy-MM-dd HH:mm"));
        teachPlanSubject.setResourceEndTime(DateUtil.getNowNewTime(endTime, "yyyy-MM-dd HH:mm"));
        teachPlanSubject.setResourceState(TeachPlanSubject.RESOURCESTATE_YES);
        teachPlanSubject.setOperator(loginName);

        //删除关联题目
        if(!StringUtil.isEmpty(delTpsrIds)){
            for(String delTpsrId : delTpsrIds.split(",")){
                teachPlanSubjectResourcesDao.delete(Long.parseLong(delTpsrId));
            }
        }

        //新增关联题目
        if(!StringUtil.isEmpty(resourcesIds)){
            for(String resourcesId : resourcesIds.split(",")){

                TeachPlanSubjectResources teachPlanSubjectResources = teachPlanSubjectResourcesDao.findByTeachPlanSubjectIdAndResourcesId(tpsId, Long.parseLong(resourcesId));
                if(null != teachPlanSubjectResources){
                    throw new BusinessException("请不要添加重复的资源");
                }
                teachPlanSubjectResources = new TeachPlanSubjectResources();
                teachPlanSubjectResources.setResourcesId(Long.parseLong(resourcesId));
                teachPlanSubjectResources.setTeachPlanSubjectId(tpsId);
                teachPlanSubjectResources.setOperator(loginName);
                teachPlanSubjectResourcesDao.save(teachPlanSubjectResources);
            }
        }
    }
}
