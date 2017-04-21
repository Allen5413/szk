package com.allen.web.controller.basic.menu;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.basic.menu.DelMenuByIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/delMenu")
public class DelMenuController extends BaseController {

    @Resource
    private DelMenuByIdService delMenuByIdService;

    @RequestMapping(value = "del")
    @ResponseBody
    public JSONObject del(@RequestParam("id") long id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        delMenuByIdService.del(id);
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
