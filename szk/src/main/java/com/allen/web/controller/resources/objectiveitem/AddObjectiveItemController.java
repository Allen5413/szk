package com.allen.web.controller.resources.objectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.service.resources.label.FindLabelForAllService;
import com.allen.service.resources.objectiveitem.AddObjectiveItemService;
import com.allen.util.StringUtil;
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
@RequestMapping("/addObjectiveItem")
public class AddObjectiveItemController extends BaseController {

    @Resource
    private AddObjectiveItemService addObjectiveItemService;
    @Resource
    private FindLabelForAllService findLabelForAllService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(HttpServletRequest request)throws Exception{
        request.setAttribute("labelList", findLabelForAllService.find());
        return "/resources/objectiveitem/add";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request,
                          ObjectiveItem objectiveItem,
                          @RequestParam("answers")String answers,
                          @RequestParam(value = "labels", required = false)String labels) throws Exception {
        JSONObject jsonObject = new JSONObject();
        addObjectiveItemService.add(objectiveItem, StringUtil.isEmpty(labels) ? null : labels.split(","), answers.split("#@#"), UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}