package com.allen.service.resources.subjectiveitem;

import com.allen.entity.resources.SubjectiveItem;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface AddSubjectiveItemService {
    public void add(SubjectiveItem subjectiveItem, String[] labels, String[] answers, String loginName)throws Exception;
}
