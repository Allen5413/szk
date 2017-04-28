package com.allen.web.controller.teachplan.teachplansubject;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.FindTeachPlanSubjectByIdService;
import com.allen.service.teachplan.teachplansubject.SetTeachPlanSubjectSiService;
import com.allen.service.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiByTpsIdService;
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
@RequestMapping(value = "/setTeachPlanSubjectSi")
public class SetTeachPlanSubjectSiController extends BaseController {

    @Resource
    private FindTeachPlanSubjectByIdService findTeachPlanSubjectByIdService;
    @Resource
    private FindTeachPlanSubjectSiByTpsIdService findTeachPlanSubjectSiByTpsIdService;
    @Resource
    private SetTeachPlanSubjectSiService setTeachPlanSubjectSiService;

    /**
     * 打开后测设置页面
     * @param id
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "open")
    public String open(@RequestParam("id") long id, HttpServletRequest request) throws Exception {
        TeachPlanSubject teachPlanSubject = findTeachPlanSubjectByIdService.find(id);
        request.setAttribute("teachPlanSubject", teachPlanSubject);
        request.setAttribute("tpssiList", findTeachPlanSubjectSiByTpsIdService.find(id));
        return "/teachplan/teachplanSubject/setSi";
    }

    /**
     * 打开选择题目的页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "openSi")
    public String openSi() throws Exception {
        return "/teachplan/teachplanSubject/setSiFindSi";
    }


    @RequestMapping(value = "set")
    @ResponseBody
    public JSONObject set(@RequestParam("tpsId") long tpsId,
                             @RequestParam(value = "delTpssiIds", required = false) String delTpssiIds,
                             @RequestParam("beginTime") String beginTime,
                             @RequestParam("endTime")String endTime,
                             @RequestParam(value = "siIds", required = false) String siIds,
                             HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        setTeachPlanSubjectSiService.setSi(tpsId, delTpssiIds, beginTime, endTime, siIds, UserUtil.getLoginUserForName(request));
        jsonObject.put("state", 0);
        return jsonObject;
    }
}
