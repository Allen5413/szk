package com.allen.web.controller.resources.objectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.resources.objectiveitem.DelObjectiveItemByIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Controller
@RequestMapping("/delObjectiveItem")
public class DelObjectiveItemController extends BaseController {

    @Resource
    private DelObjectiveItemByIdService delObjectiveItemByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "del")
    @ResponseBody
    public JSONObject del(@RequestParam("id")long id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        delObjectiveItemByIdService.del(id);
        jsonObject.put("state", 0);
        return jsonObject;
    }
}