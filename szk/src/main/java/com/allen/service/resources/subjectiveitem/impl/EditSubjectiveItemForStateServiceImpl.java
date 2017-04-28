package com.allen.service.resources.subjectiveitem.impl;


import com.allen.dao.resources.subjectiveitem.SubjectiveItemDao;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.service.resources.subjectiveitem.EditSubjectiveItemForStateService;
import com.allen.service.resources.subjectiveitem.EditSubjectiveItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class EditSubjectiveItemForStateServiceImpl implements EditSubjectiveItemForStateService {

    @Resource
    private SubjectiveItemDao subjectiveItemDao;
    @Resource
    private EditSubjectiveItemService editSubjectiveItemService;

    @Override
    public void edit(long id, int state, String loginName)throws Exception{
        SubjectiveItem subjectiveItem = subjectiveItemDao.findOne(id);
        subjectiveItem.setState(state);
        editSubjectiveItemService.edit(subjectiveItem, null, null, loginName);
    }
}
