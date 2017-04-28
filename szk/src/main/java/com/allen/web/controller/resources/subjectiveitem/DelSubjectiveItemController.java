package com.allen.web.controller.resources.subjectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.resources.subjectiveitem.DelSubjectiveItemByIdService;
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
@RequestMapping("/delSubjectiveItem")
public class DelSubjectiveItemController extends BaseController {

    @Resource
    private DelSubjectiveItemByIdService delSubjectiveItemByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "del")
    @ResponseBody
    public JSONObject del(@RequestParam("id")long id) throws Exception {
        JSONObject jsonObject = new JSONObject();
        delSubjectiveItemByIdService.del(id);
        jsonObject.put("state", 0);
        return jsonObject;
    }
}