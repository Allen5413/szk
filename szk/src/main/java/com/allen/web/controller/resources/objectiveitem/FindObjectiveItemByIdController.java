package com.allen.web.controller.resources.objectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.resources.objectiveitem.FindObjectiveItemByIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping("/findObjectiveItemById")
public class FindObjectiveItemByIdController extends BaseController {

    @Resource
    private FindObjectiveItemByIdService findObjectiveItemByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "find")
    public String find(HttpServletRequest request, @RequestParam("id")long id)throws Exception{
        JSONObject json = findObjectiveItemByIdService.find(id);
        request.setAttribute("oi", json.get("objectiveItem"));
        request.setAttribute("oiaList", json.get("oiaList"));
        return "/resources/objectiveitem/info";
    }
}
