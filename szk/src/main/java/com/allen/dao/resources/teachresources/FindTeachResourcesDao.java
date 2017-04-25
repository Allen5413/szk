package com.allen.dao.resources.teachresources;

import com.allen.dao.BaseQueryDao;
import com.allen.dao.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachResourcesDao extends BaseQueryDao {

    /**
     * 分页查询信息
     * @param paramsMap
     * @return pageInfo
     * @throws Exception
     */
    public PageInfo findPage(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception{
        String[] tableNames = {"TeachResources"};
        String defaultWhere = "1=1";
        return super.findPageByJpal(pageInfo, tableNames, defaultWhere, paramsMap, sortMap);
    }
}
