package com.allen.web.controller.resources.subjectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.service.resources.label.FindLabelForAllService;
import com.allen.service.resources.subjectiveitem.AddSubjectiveItemService;
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
@RequestMapping("/addSubjectiveItem")
public class AddSubjectiveItemController extends BaseController {

    @Resource
    private AddSubjectiveItemService addSubjectiveItemService;
    @Resource
    private FindLabelForAllService findLabelForAllService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(HttpServletRequest request)throws Exception{
        request.setAttribute("labelList", findLabelForAllService.find());
        return "/resources/subjectiveitem/add";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public JSONObject add(HttpServletRequest request,
                          SubjectiveItem subjectiveItem,
                          @RequestParam("answers")String answers,
                          @RequestParam(value = "labels", required = false)String labels) throws Exception {
        JSONObject jsonObject = new JSONObject();
        addSubjectiveItemService.add(subjectiveItem, StringUtil.isEmpty(labels) ? null : labels.split(","), answers.split("#@#"), UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}