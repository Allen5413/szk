package com.allen.web.controller.resources.subjectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.service.resources.label.FindLabelForAllService;
import com.allen.service.resources.subjectiveitem.EditSubjectiveItemService;
import com.allen.service.resources.subjectiveitem.FindSubjectiveItemByIdService;
import com.allen.util.StringUtil;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Controller
@RequestMapping("/editSubjectiveItem")
public class EditSubjectiveItemController extends BaseController {

    @Resource
    private EditSubjectiveItemService editSubjectiveItemService;
    @Resource
    private FindLabelForAllService findLabelForAllService;
    @Resource
    private FindSubjectiveItemByIdService findSubjectiveItemByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("id")long id)throws Exception{
        JSONObject json = findSubjectiveItemByIdService.find(id);
        request.setAttribute("subjectiveItem", json.get("subjectiveItem"));
        request.setAttribute("answer", null== json.get("siaList") ? "" : ((List)json.get("siaList")).get(0));
        request.setAttribute("labelList", findLabelForAllService.find());
        return "/resources/subjectiveitem/edit";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(HttpServletRequest request,
                          SubjectiveItem subjectiveItem,
                          @RequestParam("answers")String answers,
                          @RequestParam(value = "labels", required = false)String labels) throws Exception {
        JSONObject jsonObject = new JSONObject();
        editSubjectiveItemService.edit(subjectiveItem, StringUtil.isEmpty(labels) ? null : labels.split(","), answers.split("#@#"), UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}