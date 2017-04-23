package com.allen.dao.teachplan.teachplan;

import com.allen.dao.BaseQueryDao;
import com.allen.dao.PageInfo;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Allen on 2017/1/4 0004.
 */
@Service
public class FindTeachPlanDao extends BaseQueryDao {

    /**
     * 分页查询信息
     * @param paramsMap
     * @return pageInfo
     * @throws Exception
     */
    public PageInfo findPage(PageInfo pageInfo, Map<String, String> paramsMap)throws Exception{
        String field = "tp.id, tp.name tpName, u.name uName, (CASE WHEN tp.state = 0 THEN '进行中' ELSE '已结束' END) state, count(tps.id) studentCount";
        String sql = "from teach_plan tp LEFT JOIN user u ON tp.zz = u.zz ";
        sql += "LEFT JOIN teach_plan_student tps ON tp.id = tps.teach_plan_id ";
        sql += "WHERE 1 = 1 ";
        String name = paramsMap.get("name");
        String state = paramsMap.get("state");
        String studentId = paramsMap.get("studentId");

        List<Object> param = new ArrayList<Object>();
        if(!StringUtil.isEmpty(name)){
            sql += "and tp.name like ? ";
            param.add("%"+name+"%");
        }
        if(!StringUtil.isEmpty(state)){
            sql += "and tp.state = ? ";
            param.add(Integer.parseInt(state));
        }
        if(!StringUtil.isEmpty(studentId)){
            sql += "and tps.user_id = ? ";
            param.add(Long.parseLong(studentId));
        }
        sql += "group by tp.id, tp.name, u.name, tp.state ";
        sql += "order by tp.id desc";
        pageInfo = super.pageSqlQueryByNativeSqlToMap(pageInfo, sql.toString(), field, param.toArray());
        return pageInfo;
    }
}
