package com.allen.service.teachplan.teachplansubjectoi.impl;

import com.allen.dao.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiDao;
import com.allen.service.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiByTpsIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectOiByTpsIdServiceImpl implements FindTeachPlanSubjectOiByTpsIdService {

    @Resource
    private FindTeachPlanSubjectOiDao findTeachPlanSubjectOiDao;

    @Override
    public List<Map> find(long tpsId) throws Exception {
        return findTeachPlanSubjectOiDao.findTeachPlanSubjectOiByTpsId(tpsId);
    }
}
