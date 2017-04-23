package com.allen.web.controller.resources.label;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.Label;
import com.allen.service.resources.label.AddLabelService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping("/addLabel")
public class AddLabelController extends BaseController {

    @Resource
    private AddLabelService addLabelService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(){
        return "/resources/label/add";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request, Label label) throws Exception {
        JSONObject jsonObject = new JSONObject();
        label = addLabelService.add(label, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        jsonObject.put("data", label);
        return jsonObject;
    }
}
