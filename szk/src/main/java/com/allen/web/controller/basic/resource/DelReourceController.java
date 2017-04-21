package com.allen.web.controller.basic.resource;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.basic.resource.DelResourceByIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/delReource")
public class DelReourceController extends BaseController {

    @Resource
    private DelResourceByIdService delResourceByIdService;

    @RequestMapping(value = "del")
    @ResponseBody
    public JSONObject del(@RequestParam("id") long id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        delResourceByIdService.del(id);
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
