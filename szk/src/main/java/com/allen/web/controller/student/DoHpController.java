package com.allen.web.controller.student;

import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
