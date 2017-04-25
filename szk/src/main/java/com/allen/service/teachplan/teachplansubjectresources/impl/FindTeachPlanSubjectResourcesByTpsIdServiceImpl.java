package com.allen.service.teachplan.teachplansubjectresources.impl;

import com.allen.dao.teachplan.teachplansubjectresources.FindTeachPlanSubjectResourcesDao;
import com.allen.service.teachplan.teachplansubjectresources.FindTeachPlanSubjectResourcesByTpsIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/25.
 */
@Service
public class FindTeachPlanSubjectResourcesByTpsIdServiceImpl implements FindTeachPlanSubjectResourcesByTpsIdService {

    @Resource
    private FindTeachPlanSubjectResourcesDao findTeachPlanSubjectResourcesDao;

    @Override
    public List<Map> find(long tpsId) throws Exception {
        return findTeachPlanSubjectResourcesDao.findTeachPlanSubjectResourcesByTpsId(tpsId);
    }
}
