package com.allen.dao.teachplan.teachplansubjectresources;

import com.allen.dao.BaseQueryDao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectResourcesDao extends BaseQueryDao {

    /**
     * 查询一个专题下面关联的课堂讨论题目
     * @param tpsId
     * @return
     * @throws Exception
     */
    public List<Map> findTeachPlanSubjectResourcesByTpsId(long tpsId)throws Exception{
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("t.teach_plan_subject_id", tpsId);
        String fileds = "t.id, tr.name";
        String[] tableNames = {"teach_plan_subject_resources t", "teach_resources tr"};
        String defaultWhere = "tr.id = t.resources_id";
        return super.findListBySqlToMap(tableNames, fileds, defaultWhere, paramsMap, null);
    }
}
