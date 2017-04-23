package com.allen.dao.teachplan.teachplansubjectoistudent;

import com.allen.dao.BaseQueryDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachPlanSubjectOiStudentDao extends BaseQueryDao{

    /**
     * 查询一个专题下的一个题目的学生答题情况
     * @param tpsoiId
     * @return
     * @throws Exception
     */
    public List<Map> findByTpsoiId(long tpsoiId)throws Exception{
        String sql = "select u.student_code, u.name, t.time_str, t.is_right ";
        sql += "from teach_plan_subject_oi_student t, user u ";
        sql += "where t.user_id = u.id ";
        sql += "and t.tpsoi_id = ? ";
        sql += "order by u.student_code";
        List<Object> param = new ArrayList<Object>();
        param.add(tpsoiId);
        return super.sqlQueryByNativeSqlToMap(sql, param.toArray());
    }

}
