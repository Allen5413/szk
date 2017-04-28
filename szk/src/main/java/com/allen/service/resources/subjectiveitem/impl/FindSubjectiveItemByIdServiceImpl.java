package com.allen.service.resources.subjectiveitem.impl;

import com.alibaba.fastjson.JSONObject;
import com.allen.dao.resources.subjectiveitem.SubjectiveItemDao;
import com.allen.dao.resources.subjectiveitemanswer.SubjectiveItemAnswerDao;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.service.resources.subjectiveitem.FindSubjectiveItemByIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class FindSubjectiveItemByIdServiceImpl implements FindSubjectiveItemByIdService {

    @Resource
    private SubjectiveItemDao subjectiveItemDao;
    @Resource
    private SubjectiveItemAnswerDao subjectiveItemAnswerDao;

    @Override
    public JSONObject find(long id) throws Exception {
        JSONObject json = new JSONObject();
        SubjectiveItem subjectiveItem = subjectiveItemDao.findOne(id);
        List<SubjectiveItemAnswer> siaList = subjectiveItemAnswerDao.findBySubjectiveItemId(id);
        json.put("subjectiveItem", subjectiveItem);
        json.put("siaList", siaList);
        return json;
    }
}
