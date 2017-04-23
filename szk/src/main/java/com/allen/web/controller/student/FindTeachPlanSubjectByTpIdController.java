package com.allen.web.controller.student;

import com.allen.dao.PageInfo;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplan.FindTeachPlanPageService;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectPageService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/findTeachPlanSubjectByTpId")
public class FindTeachPlanSubjectByTpIdController extends BaseController {

    @Resource
    private FindTeachPlanSubjectPageService findTeachPlanSubjectPageService;

    @RequestMapping(value = "find")
    public String find(HttpServletRequest request,
                       @RequestParam("teachPlanId")long teachPlanId) throws Exception {
        Map<String, Object> paramsMap = new LinkedHashMap<String, Object>(2);
        paramsMap.put("teachPlanId", teachPlanId);
        paramsMap.put("state", TeachPlanSubject.STATE_OPEN);
        Map<String, Boolean> sortMap = new HashMap<String, Boolean>(1);
        sortMap.put("id", true);
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findTeachPlanSubjectPageService.find(pageInfo, paramsMap, sortMap);
        if(null != pageInfo.getPageResults() && 0 < pageInfo.getPageResults().size()) {
            request.setAttribute("teachPlanSubject", pageInfo.getPageResults().get(0));
        }
        return "/student/teachplanSubject";
    }
}
