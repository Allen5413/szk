package com.allen.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
public class UeditorController {
    @RequestMapping("/ueditor")
    public String login(){
        return "/ueditor";
    }
}
