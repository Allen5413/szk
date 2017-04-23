package com.allen.web.controller.teachplan.teachplan;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.AddTeachPlanService;
import com.allen.service.user.user.FindTeacherListService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Controller
@RequestMapping("/addTeachPlan")
public class AddTeachPlanController extends BaseController {

    @Resource
    private AddTeachPlanService addTeachPlanService;
    @Resource
    private FindTeacherListService findTeacherListService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(HttpServletRequest request)throws Exception{
        request.setAttribute("teacherList", findTeacherListService.find());
        return "/teachplan/teachplan/add";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request, TeachPlan teachPlan) throws Exception {
        JSONObject jsonObject = new JSONObject();
        addTeachPlanService.add(teachPlan, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}