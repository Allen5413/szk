package com.allen.web.controller.resources.resources;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.TeachResources;
import com.allen.service.resources.label.FindLabelForAllService;
import com.allen.service.resources.teachresources.EditTeachResourcesService;
import com.allen.service.resources.teachresources.FindTeachResourcesByIdService;
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
@RequestMapping("/editTeachResources")
public class EditTeachResourcesController extends BaseController {

    @Resource
    private EditTeachResourcesService editTeachResourcesService;
    @Resource
    private FindLabelForAllService findLabelForAllService;
    @Resource
    private FindTeachResourcesByIdService findTeachResourcesByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("id")long id)throws Exception{
        TeachResources teachResources = findTeachResourcesByIdService.find(id);
        request.setAttribute("teachResources", teachResources);
        request.setAttribute("labelList", findLabelForAllService.find());
        return "/resources/resources/edit";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(HttpServletRequest request,
                          TeachResources teachResources,
                          @RequestParam(value = "labels", required = false)String labels) throws Exception {
        JSONObject jsonObject = new JSONObject();
        editTeachResourcesService.edit(teachResources, StringUtil.isEmpty(labels) ? null : labels.split(","), UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}