package com.allen.web.controller.user.user;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.user.user.AddTeacherService;
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
@RequestMapping("/addTeacher")
public class AddTeacherController extends BaseController {

    @Resource
    private AddTeacherService addTeacherService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(){
        return "user/user/addTeacher";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request,
                          @RequestParam("zz") String zz,
                          @RequestParam("name") String name) throws Exception {
        JSONObject jsonObject = new JSONObject();
        addTeacherService.add(zz, name, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
