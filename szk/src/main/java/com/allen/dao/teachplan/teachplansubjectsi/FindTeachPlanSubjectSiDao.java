package com.allen.dao.teachplan.teachplansubjectsi;

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
public class FindTeachPlanSubjectSiDao extends BaseQueryDao {

    /**
     * 查询一个专题下面关联的后测设置题目
     * @param tpsId
     * @return
     * @throws Exception
     */
    public List<Map> findTeachPlanSubjectSiByTpsId(long tpsId)throws Exception{
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("t.teach_plan_subject_id", tpsId);
        String fileds = "t.id, si.name";
        String[] tableNames = {"teach_plan_subject_si t", "subjective_item si"};
        String defaultWhere = "si.id = t.subjective_item_id";
        return super.findListBySqlToMap(tableNames, fileds, defaultWhere, paramsMap, null);
    }

    /**
     * 查询一个学生专题下面关联的后测设置题目
     * @param tpsId
     * @return
     * @throws Exception
     */
    public List<Map> findStudentForSi(long tpsId, long userId)throws Exception{
        String sql = "select DISTINCT tpssi.*, tpssis.time, tpssis.time_str from ";
        sql += "teach_plan_subject_si tpssi LEFT JOIN teach_plan_subject_si_student tpssis ";
        sql += "on tpssi.id = tpssis.tpssi_id and tpssis.user_id = ? ";
        sql += "where tpssi.teach_plan_subject_id = ? ";
        sql += "order by tpssi.id";
        List<Object> param = new ArrayList<Object>();
        param.add(userId);
        param.add(tpsId);
        return super.sqlQueryByNativeSqlToMap(sql, param.toArray());
    }
}
