package com.allen.web.controller;

import com.allen.dao.PageInfo;
import com.allen.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 2016/12/20.
 */
public class BaseController {

    protected PageInfo getPageInfo(HttpServletRequest request) {
        PageInfo pageinfo = new PageInfo();
        pageinfo.setCurrentPage(1);
        pageinfo.setCountOfCurrentPage(10);
        String page = request.getParameter("page");
        if(!StringUtil.isEmpty(page)) {
            pageinfo.setCurrentPage(Integer.parseInt(page));
        }
        String rows = request.getParameter("rows");
        if(!StringUtil.isEmpty(rows)) {
            pageinfo.setCountOfCurrentPage(Integer.parseInt(rows));
        }
        return pageinfo;
    }

    protected Map<String, Boolean> getSortInfo(HttpServletRequest request){
        Map<String, Boolean> sortMap = new HashMap<String, Boolean>();
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        if(!StringUtil.isEmpty(sort)) {
            sortMap.put(sort, StringUtil.isEmpty(order) ? true : false);
        }
        return sortMap;
    }
}
