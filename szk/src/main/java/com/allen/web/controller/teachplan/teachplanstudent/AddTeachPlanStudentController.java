package com.allen.web.controller.teachplan.teachplanstudent;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.AddTeachPlanService;
import com.allen.service.teachplan.teachplanstudent.AddTeachPlanStudentService;
import com.allen.service.user.user.FindTeacherListService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Controller
@RequestMapping("/addTeachPlanStudent")
public class AddTeachPlanStudentController extends BaseController {

    @Resource
    private AddTeachPlanStudentService addTeachPlanStudentService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open()throws Exception{
        return "/teachplan/teachplanStudent/add";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request,
                          @RequestParam("teachPlanId") long teachPlanId,
                          @RequestParam("studentCodes") String studentCodes) throws Exception {
        JSONObject jsonObject = new JSONObject();
        addTeachPlanStudentService.add(UserUtil.getLoginUserForName(request), teachPlanId, studentCodes.split(","));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}