package com.allen.dao.user.user;

import com.allen.dao.BaseQueryDao;
import com.allen.dao.PageInfo;
import com.allen.entity.user.User;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/1/4 0004.
 */
@Service
public class FindUserDao extends BaseQueryDao {

    /**
     * 分页查询信息
     * @param pageInfo
     * @param name
     * @param state
     * @return
     * @throws Exception
     */
    public PageInfo findPage(PageInfo pageInfo, String name, Integer state, Integer type)throws Exception{
        String[] tableNames = {"User"};
        String defaultWhere = "state > 0";
        LinkedHashMap<String, Object> paramsMap = new LinkedHashMap<String, Object>(2);
        paramsMap.put("name",new Object[]{StringUtil.isEmpty(name) ? "" : "%"+name+"%","like"});
        paramsMap.put("state", state);
        paramsMap.put("type", type);
        Map<String, Boolean> sortMap = new HashMap<String, Boolean>(1);
        sortMap.put("id", true);
        return super.findPageByJpal(pageInfo, tableNames, defaultWhere, paramsMap, sortMap);
    }

    /**
     * 通过ZZ查询未删除的非学生用户
     * @param zz
     * @return
     * @throws Exception
     */
    public User findByZz(String zz)throws Exception{
        String fields = "u";
        String[] tableNames = {"User u"};
        LinkedHashMap<String, Object> paramsMap = new LinkedHashMap<String, Object>();
        paramsMap.put("zz",zz);
        paramsMap.put("state",new Object[]{0,">"});
        paramsMap.put("type",new Object[]{2,"<"});
        return (User) super.findByHql(tableNames, fields, paramsMap, null, User.class);
    }

    /**
     * 通过studentCode查询未删除的学生用户
     * @param studentCode
     * @return
     * @throws Exception
     */
    public User findByStudentCode(String studentCode)throws Exception{
        String fields = "u";
        String[] tableNames = {"User u"};
        LinkedHashMap<String, Object> paramsMap = new LinkedHashMap<String, Object>();
        paramsMap.put("studentCode",studentCode);
        paramsMap.put("state",new Object[]{0,">"});
        paramsMap.put("type",2);
        return (User) super.findByHql(tableNames, fields, paramsMap, null, User.class);
    }
}
