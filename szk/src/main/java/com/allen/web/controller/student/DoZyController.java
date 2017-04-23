package com.allen.web.controller.student;

import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/doZy")
public class DoZyController extends BaseController {


    @RequestMapping(value = "open")
    public String open(HttpServletRequest request) throws Exception {
        return "/student/zy/zyList";
    }

    @RequestMapping(value = "doing")
    public String doing(HttpServletRequest request) throws Exception {
        return "/student/zy/doZy";
    }
}
