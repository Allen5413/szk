package com.allen.util;


import com.allen.entity.basic.Resource;
import com.allen.entity.user.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 获取登录用户相关信息
 * Created by Allen on 2015/4/27.
 */
public class UserUtil {

    /**
     * 获取登录用户ID
     * @param request
     * @return
     */
    public static long getLoginUserForLoginId(HttpServletRequest request){
        if(null != request.getSession().getAttribute("userId")){
            return Long.parseLong(request.getSession().getAttribute("userId").toString());
        }else{
            return -1;
        }
    }

    /**
     * 获取登录用户的登录名
     * @param request
     * @return
     */
    public static String getLoginUserForLoginName(HttpServletRequest request){
        if(null != request.getSession().getAttribute("type")){
            if(Integer.parseInt(request.getSession().getAttribute("type").toString()) == User.TYPE_STUDENT) {
                return request.getSession().getAttribute("studentCode").toString();
            }else{
                return request.getSession().getAttribute("zz").toString();
            }
        }else{
            return "";
        }
    }

    /**
     * 获取登录用户的用户姓名
     * @param request
     * @return
     */
    public static String getLoginUserForName(HttpServletRequest request){
        if(null != request.getSession().getAttribute("name")){
            return request.getSession().getAttribute("name").toString();
        }else{
            return "";
        }
    }

    /**
     * 获取登录用户的类型
     * @param request
     * @return
     */
    public static String getLoginUserForType(HttpServletRequest request){
        if(null != request.getSession().getAttribute("type")){
            return request.getSession().getAttribute("type").toString();
        }else{
            return "";
        }
    }


    /**
     * 得到登录用户的所属菜单资源信息
     * @param request
     * @return
     */
    public static Map<String, List<Resource>> getLoginUserForMenu(HttpServletRequest request){
        if(null != request.getSession().getAttribute("menuMap")){
            return (Map<String, List<Resource>>)request.getSession().getAttribute("menuMap");
        }else{
            return null;
        }
    }
}
