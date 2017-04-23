package com.allen.web.controller.teachplan.teachplansubjectoi;

import com.alibaba.fastjson.JSONObject;
import com.allen.service.teachplan.teachplansubjectoi.CountOiAnswerService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping(value = "/countOiAnswer")
public class CountOiAnswerController  extends BaseController {

    @Resource
    private CountOiAnswerService countOiAnswerService;

    @RequestMapping(value = "open")
    public String open(@RequestParam("tpsId") long tpsId, HttpServletRequest request) throws Exception {
        List<JSONObject> list = countOiAnswerService.count(tpsId);
        request.setAttribute("list", list);
        return "/teachplan/teachplanSubjectOi/countOiAnswer";
    }

    @RequestMapping(value = "count")
    @ResponseBody
    public JSONObject count(@RequestParam("tpsId") long tpsId) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<JSONObject> list = countOiAnswerService.count(tpsId);
        jsonObject.put("state", 0);
        jsonObject.put("data", list);
        return jsonObject;
    }
}
