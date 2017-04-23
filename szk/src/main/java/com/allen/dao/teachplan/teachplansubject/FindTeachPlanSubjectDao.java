package com.allen.dao.teachplan.teachplansubject;

import com.allen.dao.BaseQueryDao;
import com.allen.dao.PageInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/1/4 0004.
 */
@Service
public class FindTeachPlanSubjectDao extends BaseQueryDao {

    /**
     * 分页查询信息
     * @param pageInfo
     * @return
     * @throws Exception
     */
    public PageInfo findPage(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception{
        String[] tableNames = {"TeachPlanSubject"};
        return super.findPageByJpal(pageInfo, tableNames, paramsMap, sortMap);
    }
}
