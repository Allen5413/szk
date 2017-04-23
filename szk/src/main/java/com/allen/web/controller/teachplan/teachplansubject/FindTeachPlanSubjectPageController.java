package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.PageInfo;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectPageService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Allen on 2016/12/20.
 */
@Controller
@RequestMapping(value = "/findTeachPlanSubjectPage")
public class FindTeachPlanSubjectPageController extends BaseController {

    @Resource
    private FindTeachPlanSubjectPageService findTeachPlanSubjectPageService;

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam(value="teachPlanId", required=false) long teachPlanId,
                       HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        Map<String, Object> paramsMap = new LinkedHashMap<String, Object>(1);
        paramsMap.put("teachPlanId", teachPlanId);
        Map<String, Boolean> sortMap = new HashMap<String, Boolean>(1);
        sortMap.put("id", true);
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findTeachPlanSubjectPageService.find(pageInfo, paramsMap, sortMap);
        json.put("rows", pageInfo.getPageResults());
        json.put("total", pageInfo.getTotalCount());
        return json;
    }
}
