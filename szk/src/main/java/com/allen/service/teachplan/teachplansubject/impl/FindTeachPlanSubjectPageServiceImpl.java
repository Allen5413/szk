package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.dao.PageInfo;
import com.allen.dao.teachplan.teachplansubject.FindTeachPlanSubjectDao;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachPlanSubjectPageServiceImpl implements FindTeachPlanSubjectPageService {

    @Resource
    private FindTeachPlanSubjectDao findTeachPlanSubjectDao;

    @Override
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap) throws Exception {
        return findTeachPlanSubjectDao.findPage(pageInfo, paramsMap, sortMap);
    }
}
