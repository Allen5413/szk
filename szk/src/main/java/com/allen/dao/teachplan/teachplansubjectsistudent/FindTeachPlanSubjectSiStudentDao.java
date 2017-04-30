package com.allen.dao.teachplan.teachplansubjectsistudent;

import com.allen.dao.BaseQueryDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindTeachPlanSubjectSiStudentDao extends BaseQueryDao{

    /**
     * 查询一个专题下的一个题目的学生答题情况
     * @param tpssiId
     * @return
     * @throws Exception
     */
    public List<Map> findByTpssiId(long tpssiId)throws Exception{
        String sql = "select u.student_code, u.name, t.time_str , t.answer ";
        sql += "from teach_plan_subject_si_student t, user u ";
        sql += "where t.user_id = u.id ";
        sql += "and t.tpssi_id = ? ";
        sql += "order by u.student_code";
        List<Object> param = new ArrayList<Object>();
        param.add(tpssiId);
        return super.sqlQueryByNativeSqlToMap(sql, param.toArray());
    }

}
