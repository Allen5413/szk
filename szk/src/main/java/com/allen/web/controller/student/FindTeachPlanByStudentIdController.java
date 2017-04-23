package com.allen.web.controller.student;

import com.allen.base.exception.BusinessException;
import com.allen.dao.PageInfo;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.FindTeachPlanPageService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/findTeachPlanByStudentId")
public class FindTeachPlanByStudentIdController extends BaseController {

    @Resource
    private FindTeachPlanPageService findTeachPlanPageService;

    @RequestMapping(value = "find")
    public String find(HttpServletRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("studentId", UserUtil.getLoginUserForLoginId(request)+"");
        params.put("state", TeachPlan.STATE_DOING+"");
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findTeachPlanPageService.find(pageInfo, params);
        request.setAttribute("teachPlan", pageInfo.getPageResults().get(0));
        return "/student/teachplan";
    }
}
