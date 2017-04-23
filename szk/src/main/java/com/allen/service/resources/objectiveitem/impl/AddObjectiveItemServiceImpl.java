package com.allen.service.resources.objectiveitem.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.service.resources.objectiveitem.AddObjectiveItemService;
import com.allen.service.resources.objectiveitemanswer.AddObjectiveItemAnswerService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddObjectiveItemServiceImpl implements AddObjectiveItemService {

    @Resource
    private ObjectiveItemDao objectiveItemDao;
    @Resource
    private AddObjectiveItemAnswerService addObjectiveItemAnswerService;

    @Override
    @Transactional
    public void add(ObjectiveItem objectiveItem, String[] labels, String[] answers, String loginName) throws Exception {
        ObjectiveItem objectiveItem2 = objectiveItemDao.findByName(objectiveItem.getName());
        if(null != objectiveItem2 && !StringUtil.isEmpty(objectiveItem2.getName())){
            throw new BusinessException("题目名称："+objectiveItem.getName()+"，已经存在");
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
            objectiveItem.setLabelIds(labelIds);
            objectiveItem.setLabelNames(labelNames);
        }
        objectiveItem.setState(ObjectiveItem.STATE_OPEN);
        objectiveItem.setCreator(loginName);
        objectiveItem.setOperator(loginName);
        objectiveItemDao.save(objectiveItem);

        //记录题目的答案
        if(null != answers && 0 < answers.length){
            for (String answer : answers){
                String answerStr = answer.split("_")[0];
                String flag = answer.split("_")[1];
                ObjectiveItemAnswer objectiveItemAnswer = new ObjectiveItemAnswer();
                objectiveItemAnswer.setObjectiveItemId(objectiveItem.getId());
                objectiveItemAnswer.setAnswer(answerStr);
                objectiveItemAnswer.setIsAnswer("1".equals(flag) ? ObjectiveItemAnswer.ISANSWER_YES : ObjectiveItemAnswer.ISANSWER_NOT);
                objectiveItemAnswer.setOperator(loginName);
                addObjectiveItemAnswerService.add(objectiveItemAnswer);
            }
        }
    }
}
