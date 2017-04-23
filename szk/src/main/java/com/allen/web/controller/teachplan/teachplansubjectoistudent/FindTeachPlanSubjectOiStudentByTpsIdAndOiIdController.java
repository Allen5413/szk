package com.allen.web.controller.teachplan.teachplansubjectoistudent;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.teachplan.teachplansubjectoistudent.FindTeachPlanSubjectOiStudentByTpsoiIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping(value = "/findTpsoisByTpsIdAndOiIdController")
public class FindTeachPlanSubjectOiStudentByTpsIdAndOiIdController extends BaseController {

    @Resource
    private FindTeachPlanSubjectOiStudentByTpsoiIdService findTeachPlanSubjectOiStudentByTpsoiIdService;

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam("tpsoiId") long tpsoiId) throws Exception {
        JSONObject json = new JSONObject();
        List<Map> list = findTeachPlanSubjectOiStudentByTpsoiIdService.find(tpsoiId);
        json.put("rows", list);
        return json;
    }
}
