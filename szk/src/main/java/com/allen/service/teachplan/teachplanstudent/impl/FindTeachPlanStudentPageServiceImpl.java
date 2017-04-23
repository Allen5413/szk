package com.allen.service.teachplan.teachplanstudent.impl;

import com.allen.dao.PageInfo;
import com.allen.dao.teachplan.teachplanstudent.FindTeachPlanStudentDao;
import com.allen.service.teachplan.teachplanstudent.FindTeachPlanStudentPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachPlanStudentPageServiceImpl implements FindTeachPlanStudentPageService {

    @Resource
    private FindTeachPlanStudentDao findTeachPlanStudentDao;

    @Override
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap) throws Exception {
        return findTeachPlanStudentDao.findPage(pageInfo, paramsMap, sortMap);
    }
}
