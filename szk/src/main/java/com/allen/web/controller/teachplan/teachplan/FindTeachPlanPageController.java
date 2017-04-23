package com.allen.web.controller.teachplan.teachplan;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.PageInfo;
import com.allen.service.teachplan.teachplan.FindTeachPlanPageService;
import com.allen.util.StringUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 2016/12/20.
 */
@Controller
@RequestMapping(value = "/findTeachPlanPage")
public class FindTeachPlanPageController extends BaseController {

    @Resource
    private FindTeachPlanPageService findTeachPlanPageService;

    @RequestMapping(value = "open")
    public String open() throws Exception {
        return "/teachplan/teachplan/page";
    }

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam(value="name", required=false) String name,
                       @RequestParam(value="state", required=false) String state,
                       HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("state", state);
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findTeachPlanPageService.find(pageInfo, params);
        json.put("rows", pageInfo.getPageResults());
        json.put("total", pageInfo.getTotalCount());
        return json;
    }
}
