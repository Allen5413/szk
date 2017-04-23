package com.allen.web.controller.student;

import com.allen.dao.PageInfo;
import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.FindTeachPlanPageService;
import com.allen.util.UserUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/doHp")
public class DoHpController extends BaseController {

    @RequestMapping(value = "open")
    public String open(HttpServletRequest request) throws Exception {
        return "/student/hp/hpList";
    }

    @RequestMapping(value = "doing")
    public String doing(HttpServletRequest request) throws Exception {
        return "/student/hp/doHp";
    }
}
