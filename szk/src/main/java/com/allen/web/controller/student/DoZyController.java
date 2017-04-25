package com.allen.web.controller.student;

import com.allen.service.resources.teachresources.FindTeachResourcesByTpsIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/doZy")
public class DoZyController extends BaseController {

    @Resource
    private FindTeachResourcesByTpsIdService findTeachResourcesByTpsIdService;


    @RequestMapping(value = "open")
    public String open(HttpServletRequest request, @RequestParam("tpsId")long tpsId) throws Exception {
        request.setAttribute("list", findTeachResourcesByTpsIdService.find(tpsId));
        return "/student/zy/zyList";
    }
}
