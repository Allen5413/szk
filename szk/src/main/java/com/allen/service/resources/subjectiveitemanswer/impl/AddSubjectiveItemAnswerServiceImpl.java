package com.allen.service.resources.subjectiveitemanswer.impl;

import com.allen.dao.resources.subjectiveitemanswer.SubjectiveItemAnswerDao;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.service.resources.subjectiveitemanswer.AddSubjectiveItemAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddSubjectiveItemAnswerServiceImpl implements AddSubjectiveItemAnswerService {

    @Resource
    private SubjectiveItemAnswerDao subjectiveItemAnswerDao;

    @Override
    public void add(SubjectiveItemAnswer subjectiveItemAnswer) throws Exception {
        subjectiveItemAnswerDao.save(subjectiveItemAnswer);
    }
}
