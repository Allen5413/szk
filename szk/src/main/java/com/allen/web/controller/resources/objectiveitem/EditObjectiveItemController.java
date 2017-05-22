package com.allen.web.controller.resources.objectiveitem;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.service.resources.label.FindLabelForAllService;
import com.allen.service.resources.objectiveitem.EditObjectiveItemService;
import com.allen.service.resources.objectiveitem.FindObjectiveItemByIdService;
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
@RequestMapping("/editObjectiveItem")
public class EditObjectiveItemController extends BaseController {

    @Resource
    private EditObjectiveItemService editObjectiveItemService;
    @Resource
    private FindLabelForAllService findLabelForAllService;
    @Resource
    private FindObjectiveItemByIdService findObjectiveItemByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("id")long id)throws Exception{
        JSONObject json = findObjectiveItemByIdService.find(id);
        List<ObjectiveItemAnswer> answerList = (List)json.get("oiaList");
        if(null != answerList && 0 < answerList.size()){
            for(int i=0; i<answerList.size(); i++){
                request.setAttribute("answer"+(i+1), answerList.get(i));
            }
        }
        request.setAttribute("objectiveItem", json.get("objectiveItem"));
        request.setAttribute("labelList", findLabelForAllService.find());
        return "/resources/objectiveitem/edit";
    }

    /**
     * @param request
     * @return
     */
    @RequestMapping(value = "editor")
    @ResponseBody
    public JSONObject editor(HttpServletRequest request,
                          ObjectiveItem objectiveItem,
                          @RequestParam("answers")String answers,
                          @RequestParam(value = "labels", required = false)String labels) throws Exception {
        JSONObject jsonObject = new JSONObject();
        editObjectiveItemService.edit(objectiveItem, StringUtil.isEmpty(labels) ? null : labels.split(","), answers.split("#@#"), UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}