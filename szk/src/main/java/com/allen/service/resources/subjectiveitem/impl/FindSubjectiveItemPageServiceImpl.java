package com.allen.service.resources.subjectiveitem.impl;

import com.allen.dao.PageInfo;
import com.allen.dao.resources.subjectiveitem.FindSubjectiveItemDao;
import com.allen.service.resources.subjectiveitem.FindSubjectiveItemPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindSubjectiveItemPageServiceImpl implements FindSubjectiveItemPageService {

    @Resource
    private FindSubjectiveItemDao findSubjectiveItemDao;

    @Override
    public PageInfo find(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap) throws Exception {
        return findSubjectiveItemDao.findPage(pageInfo, paramsMap, sortMap);
    }
}
