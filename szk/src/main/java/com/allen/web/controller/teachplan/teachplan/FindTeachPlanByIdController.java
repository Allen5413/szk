package com.allen.web.controller.teachplan.teachplan;

import com.allen.entity.teachplan.TeachPlan;
import com.allen.service.teachplan.teachplan.FindTeachPlanByIdService;
import com.allen.service.user.user.FindUserByZzService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Controller
@RequestMapping(value = "/findTeachPlanById")
public class FindTeachPlanByIdController  extends BaseController {

    @Resource
    private FindTeachPlanByIdService findTeachPlanByIdService;
    @Resource
    private FindUserByZzService findUserByZzService;

    @RequestMapping(value = "open")
    public String open(HttpServletRequest request,
                       @RequestParam("id")long id) throws Exception {
        TeachPlan teachPlan = findTeachPlanByIdService.find(id);
        request.setAttribute("teachPlan", teachPlan);
        request.setAttribute("userName", findUserByZzService.find(teachPlan.getZz()).getName());
        return "/teachplan/teachplan/search";
    }
}
