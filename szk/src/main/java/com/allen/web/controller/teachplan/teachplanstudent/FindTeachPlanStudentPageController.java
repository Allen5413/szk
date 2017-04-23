package com.allen.web.controller.teachplan.teachplanstudent;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.PageInfo;
import com.allen.service.teachplan.teachplanstudent.FindTeachPlanStudentPageService;
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
@RequestMapping(value = "/findTeachPlanStudentPage")
public class FindTeachPlanStudentPageController extends BaseController {

    @Resource
    private FindTeachPlanStudentPageService findTeachPlanStudentPageService;

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam(value="teachPlanId", required=false) long teachPlanId,
                       HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tps.teach_plan_id", teachPlanId);
        Map<String, Boolean> sortMap = new HashMap<String, Boolean>();
        sortMap.put("u.student_code", true);
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findTeachPlanStudentPageService.find(pageInfo, params, sortMap);
        json.put("rows", pageInfo.getPageResults());
        json.put("total", pageInfo.getTotalCount());
        return json;
    }
}
