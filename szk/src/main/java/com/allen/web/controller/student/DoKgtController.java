package com.allen.web.controller.student;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.resources.objectiveitem.FindObjectiveItemByIdService;
import com.allen.service.teachplan.teachplansubjectoi.FindTeachPlanSubjectOiByTpsIdAndStudentIdService;
import com.allen.service.teachplan.teachplansubjectoistudent.AddTeachPlanSubjectOiStudentService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/doKgt")
public class DoKgtController extends BaseController {

    @Resource
    private FindTeachPlanSubjectOiByTpsIdAndStudentIdService findTeachPlanSubjectOiByTpsIdAndStudentIdService;
    @Resource
    private FindObjectiveItemByIdService findObjectiveItemByIdService;
    @Resource
    private AddTeachPlanSubjectOiStudentService addTeachPlanSubjectOiStudentService;

    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("tpsId")long tpsId) throws Exception {
        request.setAttribute("list", findTeachPlanSubjectOiByTpsIdAndStudentIdService.find(tpsId, UserUtil.getLoginUserForLoginId(request)));
        return "/student/kgt/kgtList";
    }

    @RequestMapping(value = "doing")
    public String doing(HttpServletRequest request,
                        @RequestParam("oiId")long oiId) throws Exception {
        JSONObject json = findObjectiveItemByIdService.find(oiId);
        request.setAttribute("oi", json.get("objectiveItem"));
        request.setAttribute("oiaList", json.get("oiaList"));
        request.setAttribute("beginTime", System.currentTimeMillis());
        return "/student/kgt/doKgt";
    }

    @RequestMapping(value = "subAnswer")
    public String subAnswer(HttpServletRequest request,
                        @RequestParam("oiId")long oiId,
                        @RequestParam("tpsId")long tpsId,
                        @RequestParam("beginTime")long beginTime,
                        @RequestParam("changeAnwserIds")String changeAnwserIds) throws Exception {
        long endTime = System.currentTimeMillis();
        boolean isRight = addTeachPlanSubjectOiStudentService.add(oiId, tpsId, beginTime, endTime, changeAnwserIds,
                UserUtil.getLoginUserForLoginId(request), UserUtil.getLoginUserForName(request));

        String timeStr = "";
        long temp = endTime - beginTime;
        long minute = temp / (1000 * 60);
        long second = (temp % (1000 * 60)) / (1000);
        timeStr += minute+"分钟";
        timeStr += 0 == second ? "" : second+"秒";

        //找到下一题的id
        List<Map> list = findTeachPlanSubjectOiByTpsIdAndStudentIdService.find(tpsId, UserUtil.getLoginUserForLoginId(request));
        for(int i=0; i<list.size(); i++){
            Map map = list.get(i);
            if(oiId == Long.parseLong(map.get("objective_item_id").toString()) && i < list.size()-1){
                Map nextMap = list.get(i+1);
                request.setAttribute("nextOiId", nextMap.get("objective_item_id"));
                request.setAttribute("nextSno", i+2);
                break;
            }
        }

        request.setAttribute("isRight", isRight);
        request.setAttribute("timeStr", timeStr);
        return "/student/kgt/resultKgt";
    }

}
