package com.allen.dao.teachplan.teachplansubjectoi;

import com.allen.dao.BaseQueryDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindTeachPlanSubjectOiDao extends BaseQueryDao {

    /**
     * 查询一个专题下面关联的前测设置题目
     * @param tpsId
     * @return
     * @throws Exception
     */
    public List<Map> findTeachPlanSubjectOiByTpsId(long tpsId)throws Exception{
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("t.teach_plan_subject_id", tpsId);
        String fileds = "t.id, oi.name";
        String[] tableNames = {"teach_plan_subject_oi t", "objective_item oi"};
        String defaultWhere = "oi.id = t.objective_item_id";
        return super.findListBySqlToMap(tableNames, fileds, defaultWhere, paramsMap, null);
    }

    /**
     * 查询一个学生专题下面关联的前测设置题目
     * @param tpsId
     * @return
     * @throws Exception
     */
    public List<Map> findStudentForOi(long tpsId, long userId)throws Exception{
        String sql = "select DISTINCT tpsoi.*, tpsois.is_right, tpsois.time, tpsois.time_str from ";
        sql += "teach_plan_subject_oi tpsoi LEFT JOIN teach_plan_subject_oi_student tpsois ";
        sql += "on tpsoi.id = tpsois.tpsoi_id and tpsois.user_id = ? ";
        sql += "where tpsoi.teach_plan_subject_id = ? ";
        sql += "order by tpsoi.id";
        List<Object> param = new ArrayList<Object>();
        param.add(userId);
        param.add(tpsId);
        return super.sqlQueryByNativeSqlToMap(sql, param.toArray());
    }
}
