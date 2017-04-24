package com.allen.web.controller.student;

import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2017/4/24.
 */
@Controller
@RequestMapping(value = "/hyperLink")
public class HyperLinkController extends BaseController {

    @RequestMapping(value = "kc-1-1-03")
    public String open() throws Exception {
        return "/student/hyperlink/kc-1-1-03";
    }

    @RequestMapping(value = "kc-1-1-04")
    public String open2() throws Exception {
        return "/student/hyperlink/kc-1-1-04";
    }

    @RequestMapping(value = "kc-1-1-05")
    public String open3() throws Exception {
        return "/student/hyperlink/kc-1-1-05";
    }

    @RequestMapping(value = "kc-1-2-03")
    public String open4() throws Exception {
        return "/student/hyperlink/kc-1-2-03";
    }

    @RequestMapping(value = "kc-1-4-03")
    public String open5() throws Exception {
        return "/student/hyperlink/kc-1-4-03";
    }

    @RequestMapping(value = "kc-1-4-04")
    public String open6() throws Exception {
        return "/student/hyperlink/kc-1-4-04";
    }
}
