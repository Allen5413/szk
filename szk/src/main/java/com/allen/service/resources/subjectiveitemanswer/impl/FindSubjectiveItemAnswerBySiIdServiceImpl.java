package com.allen.service.resources.subjectiveitemanswer.impl;

import com.allen.dao.resources.subjectiveitemanswer.SubjectiveItemAnswerDao;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.service.resources.subjectiveitemanswer.FindSubjectiveItemAnswerBySiIdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/5/1 0001.
 */
@Service
public class FindSubjectiveItemAnswerBySiIdServiceImpl implements FindSubjectiveItemAnswerBySiIdService {

    @Resource
    private SubjectiveItemAnswerDao subjectiveItemAnswerDao;

    @Override
    public SubjectiveItemAnswer find(long siId) throws Exception {
        List<SubjectiveItemAnswer> list = subjectiveItemAnswerDao.findBySubjectiveItemId(siId);
        return null != list && 0 < list.size() ? list.get(0) : null;
    }
}
