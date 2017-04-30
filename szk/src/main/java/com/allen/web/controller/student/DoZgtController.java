package com.allen.web.controller.student;

import com.alibaba.fastjson.JSONObject;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.entity.teachplan.TeachPlanSubjectSi;
import com.allen.entity.teachplan.TeachPlanSubjectSiStudent;
import com.allen.entity.teachplan.TeachPlanSubjectSiStudentAnswer;
import com.allen.service.resources.subjectiveitem.FindSubjectiveItemByIdService;
import com.allen.service.resources.subjectiveitemanswer.FindSubjectiveItemAnswerBySiIdService;
import com.allen.service.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiByTpsIdAndSIdService;
import com.allen.service.teachplan.teachplansubjectsi.FindTeachPlanSubjectSiByTpsIdAndStudentIdService;
import com.allen.service.teachplan.teachplansubjectsistudent.AddTeachPlanSubjectSiStudentService;
import com.allen.service.teachplan.teachplansubjectsistudent.FindTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService;
import com.allen.service.teachplan.teachplansubjectsistudentanswer.FindTeachPlanSubjectSiStudentAnswerByTpssisIdService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/doZgt")
public class DoZgtController extends BaseController {

    @Resource
    private FindTeachPlanSubjectSiByTpsIdAndStudentIdService findTeachPlanSubjectSiByTpsIdAndStudentIdService;
    @Resource
    private FindSubjectiveItemByIdService findSubjectiveItemByIdService;
    @Resource
    private AddTeachPlanSubjectSiStudentService addTeachPlanSubjectSiStudentService;
    @Resource
    private FindTeachPlanSubjectSiByTpsIdAndSIdService findTeachPlanSubjectSiByTpsIdAndSIdService;
    @Resource
    private FindTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService findTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService;
    @Resource
    private FindTeachPlanSubjectSiStudentAnswerByTpssisIdService findTeachPlanSubjectSiStudentAnswerByTpssisIdService;
    @Resource
    private FindSubjectiveItemAnswerBySiIdService findSubjectiveItemAnswerBySiIdService;

    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("tpsId")long tpsId) throws Exception {
        request.setAttribute("list", findTeachPlanSubjectSiByTpsIdAndStudentIdService.find(tpsId, UserUtil.getLoginUserForLoginId(request)));
        return "/student/zgt/zgtList";

    }

    @RequestMapping(value = "doing")
    public String doing(HttpServletRequest request,
                        @RequestParam("siId")long siId) throws Exception {
        JSONObject json = findSubjectiveItemByIdService.find(siId);
        request.setAttribute("si", json.get("subjectiveItem"));
        request.setAttribute("siaList", json.get("siaList"));
        request.setAttribute("beginTime", System.currentTimeMillis());
        return "/student/zgt/doZgt";
    }

    @RequestMapping(value = "subAnswer")
    public String subAnswer(HttpServletRequest request,
                            @RequestParam("siId")long siId,
                            @RequestParam("tpsId")long tpsId,
                            @RequestParam(value = "beginTime", required = false)Long beginTime,
                            @RequestParam(value = "answer", required = false)String answer,
                            @RequestParam("flag")int flag) throws Exception {
        //提交答案
        if(0 == flag) {
            long endTime = System.currentTimeMillis();
            addTeachPlanSubjectSiStudentService.add(siId, tpsId, beginTime, endTime, answer,
                    UserUtil.getLoginUserForLoginId(request), UserUtil.getLoginUserForName(request));

            String timeStr = "";
            long temp = endTime - beginTime;
            long minute = temp / (1000 * 60);
            long second = (temp % (1000 * 60)) / (1000);
            timeStr += minute + "分钟";
            timeStr += 0 == second ? "" : second + "秒";
            request.setAttribute("timeStr", timeStr);
        }

        SubjectiveItem subjectiveItem = (SubjectiveItem) ((JSONObject)findSubjectiveItemByIdService.find(siId)).get("subjectiveItem");
        TeachPlanSubjectSi teachPlanSubjectSi = findTeachPlanSubjectSiByTpsIdAndSIdService.find(tpsId, siId);
        TeachPlanSubjectSiStudent teachPlanSubjectSiStudent = findTeachPlanSubjectSiStudentByTpssiIdAndStudentIdService.find(teachPlanSubjectSi.getId(), UserUtil.getLoginUserForLoginId(request));
        TeachPlanSubjectSiStudentAnswer teachPlanSubjectSiStudentAnswer = findTeachPlanSubjectSiStudentAnswerByTpssisIdService.find(teachPlanSubjectSiStudent.getId());
        request.setAttribute("si", subjectiveItem);
        request.setAttribute("studentAnswer", teachPlanSubjectSiStudent.getAnswer());
        request.setAttribute("answer", teachPlanSubjectSiStudentAnswer);

        //找到下一题的id
        List<Map> list = findTeachPlanSubjectSiByTpsIdAndStudentIdService.find(tpsId, UserUtil.getLoginUserForLoginId(request));
        for(int i=0; i<list.size(); i++){
            Map map = list.get(i);
            if(siId == Long.parseLong(map.get("subjective_item_id").toString()) && i < list.size()-1){
                Map nextMap = list.get(i+1);
                request.setAttribute("nextSiId", nextMap.get("subjective_item_id"));
                request.setAttribute("nextSno", i+2);
                break;
            }
        }
        return "/student/zgt/resultZgt";
    }

    @RequestMapping(value = "subDoing")
    @ResponseBody
    public JSONObject subDoing(HttpServletRequest request,
                            @RequestParam("siId")long siId,
                            @RequestParam("tpsId")long tpsId,
                            @RequestParam(value = "beginTime", required = false)Long beginTime,
                            @RequestParam(value = "answer", required = false)String answer) throws Exception {
        JSONObject json = new JSONObject();
//        long endTime = System.currentTimeMillis();
//        addTeachPlanSubjectSiStudentService.add(siId, tpsId, beginTime, endTime, answer,
//                UserUtil.getLoginUserForLoginId(request), UserUtil.getLoginUserForName(request));
//
//        String timeStr = "";
//        long temp = endTime - beginTime;
//        long minute = temp / (1000 * 60);
//        long second = (temp % (1000 * 60)) / (1000);
//        timeStr += minute + "分钟";
//        timeStr += 0 == second ? "" : second + "秒";
//        request.setAttribute("timeStr", timeStr);
//        //找到下一题的id
//        List<Map> list = findTeachPlanSubjectSiByTpsIdAndStudentIdService.find(tpsId, UserUtil.getLoginUserForLoginId(request));
//        for(int i=0; i<list.size(); i++){
//            Map map = list.get(i);
//            if(siId == Long.parseLong(map.get("subjective_item_id").toString()) && i < list.size()-1){
//                Map nextMap = list.get(i+1);
//                request.setAttribute("nextSiId", nextMap.get("subjective_item_id"));
//                request.setAttribute("nextSno", i+2);
//                break;
//            }
//        }
        json.put("state", 0);
        return json;
    }
}
