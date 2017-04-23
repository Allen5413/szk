package com.allen.web.controller.user.user;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.PageInfo;
import com.allen.service.user.user.FindUserPageService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2016/12/20.
 */
@Controller
@RequestMapping(value = "/findTeacherPage")
public class FindTeacherPageController extends BaseController {
    @Resource
    private FindUserPageService findUserPageService;

    @RequestMapping(value = "open")
    public String open() throws Exception {
        return "/user/user/teacherPage";
    }

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam(value="name", required=false) String name,
                       @RequestParam(value="state", required=false) Integer state,
                       @RequestParam(value="type", required=false) Integer type,
                       HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findUserPageService.find(pageInfo, name, state, type);
        json.put("rows", pageInfo.getPageResults());
        json.put("total", pageInfo.getTotalCount());
        return json;
    }
}
