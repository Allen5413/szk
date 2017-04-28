package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.dao.teachplan.teachplansubjectsi.TeachPlanSubjectSiDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.entity.teachplan.TeachPlanSubjectSi;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectSiService;
import com.allen.util.DateUtil;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class SetTeachPlanSubjectSiServiceImpl implements SetTeachPlanSubjectSiService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;
    @Resource
    private TeachPlanSubjectSiDao teachPlanSubjectSiDao;

    @Override
    @Transactional
    public void setSi(long tpsId, String delTpssiIds, String beginTime, String endTime, String siIds, String loginName)throws Exception{
        //修改专题的后测开始结束时间，后测状态为已设置
        TeachPlanSubject teachPlanSubject = teachPlanSubjectDao.findOne(tpsId);
        teachPlanSubject.setSubjectiveBeginTime(DateUtil.getNowNewTime(beginTime, "yyyy-MM-dd HH:mm"));
        teachPlanSubject.setSubjectiveEndTime(DateUtil.getNowNewTime(endTime, "yyyy-MM-dd HH:mm"));
        teachPlanSubject.setSubjectiveState(TeachPlanSubject.SUBJECTIVESTATE_YES);
        teachPlanSubject.setOperator(loginName);

        //删除关联题目
        if(!StringUtil.isEmpty(delTpssiIds)){
            for(String delTpsoiId : delTpssiIds.split(",")){
                teachPlanSubjectSiDao.delete(Long.parseLong(delTpsoiId));
            }
        }

        //新增关联题目
        if(!StringUtil.isEmpty(siIds)){
            for(String siId : siIds.split(",")){

                TeachPlanSubjectSi teachPlanSubjectSi = teachPlanSubjectSiDao.findByTeachPlanSubjectIdAndSubjectiveItemId(tpsId, Long.parseLong(siId));
                if(null != teachPlanSubjectSi){
                    throw new BusinessException("请不要添加重复的题目");
                }
                teachPlanSubjectSi = new TeachPlanSubjectSi();
                teachPlanSubjectSi.setSubjectiveItemId(Long.parseLong(siId));
                teachPlanSubjectSi.setTeachPlanSubjectId(tpsId);
                teachPlanSubjectSi.setOperator(loginName);
                teachPlanSubjectSiDao.save(teachPlanSubjectSi);
            }
        }
    }
}
