package com.allen.web.controller.resources.subjectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.resources.subjectiveitem.EditSubjectiveItemForStateService;
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
@RequestMapping("/editSubjectiveItemForState")
public class EditSubjectiveItemForStateController extends BaseController {

    @Resource
    private EditSubjectiveItemForStateService editSubjectiveItemForStateService;

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(HttpServletRequest request,
                          @RequestParam("id")long id,
                          @RequestParam("state")int state) throws Exception {
        JSONObject jsonObject = new JSONObject();
        editSubjectiveItemForStateService.edit(id, state, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}