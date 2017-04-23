package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.AddTeachPlanSubjectService;
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
@RequestMapping("/addTeachPlanSubject")
public class AddTeachPlanSubjectController extends BaseController {

    @Resource
    private AddTeachPlanSubjectService addTeachPlanSubjectService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open()throws Exception{
        return "/teachplan/teachplanSubject/add";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request,
                          TeachPlanSubject teachPlanSubject) throws Exception {
        JSONObject jsonObject = new JSONObject();
        addTeachPlanSubjectService.add(UserUtil.getLoginUserForName(request), teachPlanSubject);
        jsonObject.put("state", 0);
        return jsonObject;
    }
}