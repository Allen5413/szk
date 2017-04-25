package com.allen.web.controller.resources.resources;

import com.allen.entity.resources.TeachResources;
import com.allen.service.resources.teachresources.FindTeachResourcesByIdService;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Controller
@RequestMapping("/findTeachResourcesById")
public class FindTeachResourcesByIdController extends BaseController {

    @Resource
    private FindTeachResourcesByIdService findTeachResourcesByIdService;

    /**
     * @return
     */
    @RequestMapping(value = "find")
    public String find(HttpServletRequest request, @RequestParam("id")long id)throws Exception{
        TeachResources teachResources = findTeachResourcesByIdService.find(id);
        request.setAttribute("teachResources", teachResources);
        return "/resources/resources/info";
    }
}
