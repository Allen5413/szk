package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectForNameService;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectForStateService;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectByIdService;
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
 * Created by Allen on 2015/5/25.
 */
@Controller
@RequestMapping(value = "/editTeachPlanSubjectForName")
public class EditTeachPlanSubjectForNameController extends BaseController{

    @Resource
    private EditTeachPlanSubjectForNameService editTeachPlanSubjectForNameService;
    @Resource
    private FindTeachPlanSubjectByIdService findTeachPlanSubjectByIdService;

    @RequestMapping(value = "open")
    public String open(@RequestParam("id") long id, HttpServletRequest request) throws Exception {
        TeachPlanSubject teachPlanSubject = findTeachPlanSubjectByIdService.find(id);
        request.setAttribute("teachPlanSubject", teachPlanSubject);
        return "/teachplan/teachplanSubject/edit";
    }

    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(@RequestParam("id") long id,
                             @RequestParam("name") String name,
                             HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        editTeachPlanSubjectForNameService.edit(id, name, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}