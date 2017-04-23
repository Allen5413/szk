package com.allen.dao.teachplan.teachplanstudent;

import com.allen.dao.BaseQueryDao;
import com.allen.dao.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Allen on 2017/1/4 0004.
 */
@Service
public class FindTeachPlanStudentDao extends BaseQueryDao {

    /**
     * 分页查询信息
     * @param paramsMap
     * @return pageInfo
     * @throws Exception
     */
    public PageInfo findPage(PageInfo pageInfo, Map<String, Object> paramsMap, Map<String, Boolean> sortMap)throws Exception{
        String fields = "tps.*, u.name uName, u.student_code";
        String[] tableNames = {"teach_plan_student tps, user u"};
        String defaultWhere = "tps.user_id = u.id";
        return super.findPageByNativeSqlToMap(pageInfo, fields, defaultWhere, tableNames, paramsMap, sortMap);
    }
}
