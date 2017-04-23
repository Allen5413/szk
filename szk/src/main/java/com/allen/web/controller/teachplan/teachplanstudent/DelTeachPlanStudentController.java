package com.allen.web.controller.teachplan.teachplanstudent;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.teachplan.teachplanstudent.DelTeachPlanStudentByIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Allen on 2015/5/25.
 */
@Controller
@RequestMapping(value = "/delTeachPlanStudent")
public class DelTeachPlanStudentController extends BaseController{
    @Resource
    private DelTeachPlanStudentByIdService delTeachPlanStudentByIdService;

    @RequestMapping(value = "del")
    @ResponseBody
    public JSONObject del(@RequestParam("id") long id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        delTeachPlanStudentByIdService.del(id);
        jsonObject.put("state", 0);
        return jsonObject;
    }
}