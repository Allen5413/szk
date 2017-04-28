package com.allen.web.controller.student;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.PageInfo;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.resources.objectiveitem.FindObjectiveItemByIdService;
import com.allen.service.resources.subjectiveitem.FindSubjectiveItemByIdService;
import com.allen.service.teachplan.teachplan.FindTeachPlanPageService;
import com.allen.service.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiByTpsIdAndStudentIdService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/doZgt")
public class DoZgtController extends BaseController {

    @Resource
    private FindTeachPlanSubjectSiByTpsIdAndStudentIdService findTeachPlanSubjectSiByTpsIdAndStudentIdService;
    @Resource
    private FindSubjectiveItemByIdService findSubjectiveItemByIdService;

    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("tpsId")long tpsId) throws Exception {
        request.setAttribute("list", findTeachPlanSubjectSiByTpsIdAndStudentIdService.find(tpsId, UserUtil.getLoginUserForLoginId(request)));
        return "/student/zgt/zgtList";

    }

    @RequestMapping(value = "doing")
    public String doing(HttpServletRequest request,
                        @RequestParam("siId")long siId) throws Exception {
        JSONObject json = findSubjectiveItemByIdService.find(siId);
        request.setAttribute("si", json.get("subjectiveItem"));
        request.setAttribute("siaList", json.get("siaList"));
        request.setAttribute("beginTime", System.currentTimeMillis());
        return "/student/zgt/doZgt";
    }
}
