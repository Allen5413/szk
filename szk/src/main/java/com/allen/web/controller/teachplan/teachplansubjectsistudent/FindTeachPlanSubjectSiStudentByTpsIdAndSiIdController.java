package com.allen.web.controller.teachplan.teachplansubjectsistudent;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.teachplan.teachplansubjectsistudent.FindTeachPlanSubjectSiStudentByTpssiIdService;
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
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping(value = "/findTpssisByTpsIdAndSiIdController")
public class FindTeachPlanSubjectSiStudentByTpsIdAndSiIdController extends BaseController {

    @Resource
    private FindTeachPlanSubjectSiStudentByTpssiIdService findTeachPlanSubjectSiStudentByTpssiIdService;

    @RequestMapping(value = "open")
    public String open() throws Exception {
        return "/teachplan/teachplanSubjectSi/countSiAnswer";
    }

    @RequestMapping(value = "searchContent")
    public String searchContent() throws Exception {
        return "/teachplan/teachplanSubjectSi/searchContentAnswer";
    }

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam("tpssiId") long tpssiId) throws Exception {
        JSONObject json = new JSONObject();
        List<Map> list = findTeachPlanSubjectSiStudentByTpssiIdService.find(tpssiId);
        json.put("rows", list);
        return json;
    }
}
