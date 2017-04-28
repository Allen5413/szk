package com.allen.service.resources.subjectiveitem.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.subjectiveitem.SubjectiveItemDao;
import com.allen.dao.resources.subjectiveitemanswer.SubjectiveItemAnswerDao;
import com.allen.entity.resources.SubjectiveItem;
import com.allen.entity.resources.SubjectiveItemAnswer;
import com.allen.service.resources.subjectiveitem.EditSubjectiveItemService;
import com.allen.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class EditSubjectiveItemServiceImpl implements EditSubjectiveItemService {

    @Resource
    private SubjectiveItemDao subjectiveItemDao;
    @Resource
    private SubjectiveItemAnswerDao subjectiveItemAnswerDao;

    @Override
    @Transactional
    public void edit(SubjectiveItem subjectiveItem, String[] labels, String[] answers, String loginName) throws Exception {
        SubjectiveItem subjectiveItem2 = subjectiveItemDao.findByName(subjectiveItem.getName());
        if(null != subjectiveItem2 && subjectiveItem2.getId() != subjectiveItem.getId()){
            throw new BusinessException("题目名称："+subjectiveItem.getName()+"，已经存在");
        }
        SubjectiveItem oldSubjectiveItem = subjectiveItemDao.findOne(subjectiveItem.getId());
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
            oldSubjectiveItem.setLabelIds(labelIds);
            oldSubjectiveItem.setLabelNames(labelNames);
        }else{
            oldSubjectiveItem.setLabelIds(null);
            oldSubjectiveItem.setLabelNames(null);
        }
        if(null != subjectiveItem.getState()){
            oldSubjectiveItem.setState(subjectiveItem.getState());
        }
        oldSubjectiveItem.setName(subjectiveItem.getName());
        oldSubjectiveItem.setReference(subjectiveItem.getReference());
        oldSubjectiveItem.setOperator(loginName);
        oldSubjectiveItem.setOperateTime(DateUtil.getLongNowTime());
        subjectiveItemDao.save(oldSubjectiveItem);

        //记录题目的答案
        if(null != answers && 0 < answers.length){
            for (String answer : answers){
                SubjectiveItemAnswer subjectiveItemAnswer = subjectiveItemAnswerDao.findBySubjectiveItemId(subjectiveItem.getId()).get(0);
                subjectiveItemAnswer.setAnswer(answer);
                subjectiveItemAnswer.setOperator(loginName);
                subjectiveItemAnswer.setOperateTime(DateUtil.getLongNowTime());
                subjectiveItemAnswerDao.save(subjectiveItemAnswer);
            }
        }
    }
}
