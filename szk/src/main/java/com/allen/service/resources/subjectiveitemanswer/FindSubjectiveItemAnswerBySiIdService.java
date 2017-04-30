package com.allen.service.resources.subjectiveitemanswer;

import com.allen.entity.resources.SubjectiveItemAnswer;

/**
 * Created by Allen on 2017/5/1 0001.
 */
public interface FindSubjectiveItemAnswerBySiIdService {
    public SubjectiveItemAnswer find(long siId)throws Exception;
}
