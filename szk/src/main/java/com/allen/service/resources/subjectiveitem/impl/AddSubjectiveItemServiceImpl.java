package com.allen.service.resources.subjectiveitem.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.subjectiveitem.SubjectiveItemDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.service.resources.subjectiveitem.AddSubjectiveItemService;
import com.allen.service.resources.subjectiveitemanswer.AddSubjectiveItemAnswerService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddSubjectiveItemServiceImpl implements AddSubjectiveItemService {

    @Resource
    private SubjectiveItemDao subjectiveItemDao;
    @Resource
    private AddSubjectiveItemAnswerService addSubjectiveItemAnswerService;

    @Override
    @Transactional
    public void add(SubjectiveItem subjectiveItem, String[] labels, String[] answers, String loginName) throws Exception {
        SubjectiveItem subjectiveItem2 = subjectiveItemDao.findByName(subjectiveItem.getName());
        if(null != subjectiveItem2 && !StringUtil.isEmpty(subjectiveItem2.getName())){
            throw new BusinessException("题目名称："+subjectiveItem.getName()+"，已经存在");
        }
        if(null != labels && 0 < labels.length){
            String labelIds = "";
            String labelNames = "";
            for(int i = 0; i < labels.length; i++){
                String label = labels[i];
                if(0 < i){
                    labelIds += ",";
                    labelNames += ",";
                }
                labelIds += label.split("_")[0];
                labelNames += label.split("_")[1];
            }
            subjectiveItem.setLabelIds(labelIds);
            subjectiveItem.setLabelNames(labelNames);
        }
        subjectiveItem.setState(ObjectiveItem.STATE_OPEN);
        subjectiveItem.setCreator(loginName);
        subjectiveItem.setOperator(loginName);
        subjectiveItemDao.save(subjectiveItem);

        //记录题目的答案
        if(null != answers && 0 < answers.length){
            for (String answer : answers){
                SubjectiveItemAnswer subjectiveItemAnswer = new SubjectiveItemAnswer();
                subjectiveItemAnswer.setSubjectiveItemId(subjectiveItem.getId());
                subjectiveItemAnswer.setAnswer(answer);
                subjectiveItemAnswer.setOperator(loginName);
                addSubjectiveItemAnswerService.add(subjectiveItemAnswer);
            }
        }
    }
}
