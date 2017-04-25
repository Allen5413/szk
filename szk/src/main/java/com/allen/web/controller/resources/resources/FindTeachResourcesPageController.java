package com.allen.web.controller.resources.resources;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.PageInfo;
import com.allen.service.resources.teachresources.FindTeachResourcesPageService;
import com.allen.util.StringUtil;
import com.allen.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Controller
@RequestMapping(value = "/findTeachResourcesPage")
public class FindTeachResourcesPageController extends BaseController {

    @Resource
    private FindTeachResourcesPageService findTeachResourcesPageService;

    @RequestMapping(value = "open")
    public String open() throws Exception {
        return "/resources/resources/page";
    }

    @RequestMapping(value = "find")
    @ResponseBody
    public JSONObject find(@RequestParam(value="name", required=false) String name,
                           @RequestParam(value="label", required=false) String label,
                           HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", new Object[]{StringUtil.isEmpty(name) ? "" : "%"+name+"%","like"});
        params.put("labelStr", new Object[]{StringUtil.isEmpty(label) ? "" : "%"+label+"%","like"});
        Map<String, Boolean> sortMap = super.getSortInfo(request);
        PageInfo pageInfo = super.getPageInfo(request);
        pageInfo = findTeachResourcesPageService.find(pageInfo, params, sortMap);
        json.put("rows", pageInfo.getPageResults());
        json.put("total", pageInfo.getTotalCount());
        return json;
    }
}
