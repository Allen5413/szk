package com.allen.service.teachplan.teachplan.impl;

import com.allen.dao.PageInfo;
import com.allen.dao.teachplan.teachplan.FindTeachPlanDao;
import com.allen.service.teachplan.teachplan.FindTeachPlanPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Service
public class FindTeachPlanPageServiceImpl implements FindTeachPlanPageService {

    @Resource
    private FindTeachPlanDao findTeachPlanDao;

    @Override
    public PageInfo find(PageInfo pageInfo, Map<String, String> paramsMap) throws Exception {
        return findTeachPlanDao.findPage(pageInfo, paramsMap);
    }
}
