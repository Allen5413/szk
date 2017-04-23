package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectForStateService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2015/5/25.
 */
@Controller
@RequestMapping(value = "/editTeachPlanStudentForState")
public class EditTeachPlanSubjectForStateController extends BaseController{
    @Resource
    private EditTeachPlanSubjectForStateService editTeachPlanSubjectForStateService;

    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(@RequestParam("id") long id,
                             @RequestParam("state") int state,
                             HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        editTeachPlanSubjectForStateService.edit(id, state, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}