package com.allen.service.teachplan.teachplansubjectsi.impl;

import com.allen.dao.teachplan.teachplansubjectsi.TeachPlanSubjectSiDao;
import com.allen.entity.teachplan.TeachPlanSubjectSi;
import com.allen.service.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiByTpsIdAndSIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/30 0030.
 */
@Service
public class FindTeachPlanSubjectSiByTpsIdAndSIdServiceImpl implements FindTeachPlanSubjectSiByTpsIdAndSIdService {

    @Resource
    private TeachPlanSubjectSiDao teachPlanSubjectSiDao;

    @Override
    public TeachPlanSubjectSi find(long tpsId, long sId) throws Exception {
        return teachPlanSubjectSiDao.findByTeachPlanSubjectIdAndSubjectiveItemId(tpsId, sId);
    }
}
