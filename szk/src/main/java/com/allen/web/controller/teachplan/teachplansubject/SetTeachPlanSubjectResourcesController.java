package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectByIdService;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectOiService;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectResourcesService;
import com.allen.service.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiByTpsIdService;
import com.allen.service.teachplan.teachplansubjectresources.FindTeachPlanSubjectResourcesByTpsIdService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping(value = "/setTeachPlanSubjectResources")
public class SetTeachPlanSubjectResourcesController extends BaseController {

    @Resource
    private FindTeachPlanSubjectByIdService findTeachPlanSubjectByIdService;
    @Resource
    private FindTeachPlanSubjectResourcesByTpsIdService findTeachPlanSubjectResourcesByTpsIdService;
    @Resource
    private SetTeachPlanSubjectResourcesService setTeachPlanSubjectResourcesService;

    /**
     * 打开课堂讨论设置页面
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "open")
    public String open(@RequestParam("id") long id, HttpServletRequest request) throws Exception {
        TeachPlanSubject teachPlanSubject = findTeachPlanSubjectByIdService.find(id);
        request.setAttribute("teachPlanSubject", teachPlanSubject);
        request.setAttribute("tpsrList", findTeachPlanSubjectResourcesByTpsIdService.find(id));
        return "/teachplan/teachplanSubject/setResources";
    }

    /**
     * 打开选择题目的页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "openResources")
    public String openResources() throws Exception {
        return "/teachplan/teachplanSubject/setResourcesFindResources";
    }


    @RequestMapping(value = "set")
    @ResponseBody
    public JSONObject set(@RequestParam("tpsId") long tpsId,
                             @RequestParam(value = "delTpsrIds", required = false) String delTpsrIds,
                             @RequestParam("beginTime") String beginTime,
                             @RequestParam("endTime")String endTime,
                             @RequestParam(value = "resourcesIds", required = false) String resourcesIds,
                             HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        setTeachPlanSubjectResourcesService.setResources(tpsId, delTpsrIds, beginTime, endTime, resourcesIds, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
