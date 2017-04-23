package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectByIdService;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectOiService;
import com.allen.service.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiByTpsIdService;
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
@RequestMapping(value = "/setTeachPlanSubjectOi")
public class SetTeachPlanSubjectOiController extends BaseController {

    @Resource
    private FindTeachPlanSubjectByIdService findTeachPlanSubjectByIdService;
    @Resource
    private FindTeachPlanSubjectOiByTpsIdService findTeachPlanSubjectOiByTpsIdService;
    @Resource
    private SetTeachPlanSubjectOiService setTeachPlanSubjectOiService;

    /**
     * 打开前测设置页面
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "open")
    public String open(@RequestParam("id") long id, HttpServletRequest request) throws Exception {
        TeachPlanSubject teachPlanSubject = findTeachPlanSubjectByIdService.find(id);
        request.setAttribute("teachPlanSubject", teachPlanSubject);
        request.setAttribute("tpsoiList", findTeachPlanSubjectOiByTpsIdService.find(id));
        return "/teachplan/teachplanSubject/setOi";
    }

    /**
     * 打开选择题目的页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "openOi")
    public String openOi() throws Exception {
        return "/teachplan/teachplanSubject/setOiFindOi";
    }


    @RequestMapping(value = "set")
    @ResponseBody
    public JSONObject set(@RequestParam("tpsId") long tpsId,
                             @RequestParam(value = "delTpsoiIds", required = false) String delTpsoiIds,
                             @RequestParam("beginTime") String beginTime,
                             @RequestParam("endTime")String endTime,
                             @RequestParam(value = "oiIds", required = false) String oiIds,
                             HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        setTeachPlanSubjectOiService.setOi(tpsId, delTpsoiIds, beginTime, endTime, oiIds, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
