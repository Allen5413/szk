package com.allen.web.controller.teachplan.teachplan;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.basic.Menu;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.entity.user.User;
import com.allen.service.basic.menu.EditMenuService;
import com.allen.service.basic.menu.FindMenuByIdService;
import com.allen.service.teachplan.teachplan.EditTeachPlanService;
import com.allen.service.teachplan.teachplan.FindTeachPlanByIdService;
import com.allen.service.user.user.FindTeacherListService;
import com.allen.service.user.user.FindUserByZzService;
import com.allen.util.DateUtil;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 修改教学计划
 * Created by Allen on 2015/4/28.
 */
@Controller
@RequestMapping(value = "/editTeachPlan")
public class EditTeachPlanController extends BaseController {

    @Resource
    private EditTeachPlanService editTeachPlanService;
    @Resource
    private FindTeachPlanByIdService findTeachPlanByIdService;
    @Resource
    private FindTeacherListService findTeacherListService;
    @Resource
    private FindUserByZzService findUserByZzService;


    @RequestMapping(value = "open")
    public String open(@RequestParam("id") long id, HttpServletRequest request) throws Exception {
        TeachPlan teachPlan = findTeachPlanByIdService.find(id);
        List<User> teacherList = findTeacherListService.find();
        request.setAttribute("teachPlan", teachPlan);
        request.setAttribute("teacherList", teacherList);
        return "/teachplan/teachplan/edit";
    }


    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(HttpServletRequest request, TeachPlan teachPlan)throws Exception{
        JSONObject jsonObject = new JSONObject();
        if(null != teachPlan) {
            editTeachPlanService.edit(teachPlan, UserUtil.getLoginUserForName(request));
            User user = findUserByZzService.find(teachPlan.getZz());
            JSONObject json = new JSONObject();
            json.put("tpName", teachPlan.getName());
            json.put("uName", user.getName());
            json.put("detail", teachPlan.getDetail());
            jsonObject.put("data", json);
        }
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
