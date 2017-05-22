package com.allen.service.resources.objectiveitem.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.service.resources.objectiveitem.EditObjectiveItemService;
import com.allen.service.resources.objectiveitemanswer.AddObjectiveItemAnswerService;
import com.allen.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class EditObjectiveItemServiceImpl implements EditObjectiveItemService {

    @Resource
    private ObjectiveItemDao objectiveItemDao;
    @Resource
    private ObjectiveItemAnswerDao objectiveItemAnswerDao;
    @Resource
    private AddObjectiveItemAnswerService addObjectiveItemAnswerService;

    @Override
    @Transactional
    public void edit(ObjectiveItem objectiveItem, String[] labels, String[] answers, String loginName) throws Exception {
        ObjectiveItem objectiveItem2 = objectiveItemDao.findByName(objectiveItem.getName());
        if(null != objectiveItem2 && objectiveItem2.getId() != objectiveItem.getId()){
            throw new BusinessException("题目名称："+objectiveItem.getName()+"，已经存在");
        }
        ObjectiveItem oldObjectiveItem = objectiveItemDao.findOne(objectiveItem.getId());
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
            oldObjectiveItem.setLabelIds(labelIds);
            oldObjectiveItem.setLabelNames(labelNames);
        }else{
            oldObjectiveItem.setLabelIds(null);
            oldObjectiveItem.setLabelNames(null);
        }
        if(null != objectiveItem.getState()){
            oldObjectiveItem.setState(objectiveItem.getState());
        }
        oldObjectiveItem.setName(objectiveItem.getName());
        oldObjectiveItem.setType(objectiveItem.getType());
        oldObjectiveItem.setSelectCount(objectiveItem.getSelectCount());
        oldObjectiveItem.setReference(objectiveItem.getReference());
        oldObjectiveItem.setRemark(objectiveItem.getRemark());
        oldObjectiveItem.setOperator(loginName);
        oldObjectiveItem.setOperateTime(DateUtil.getLongNowTime());
        objectiveItemDao.save(oldObjectiveItem);

        //删除题目之前的答案
        objectiveItemAnswerDao.delByObjectiveItemId(oldObjectiveItem.getId());

        //重新添加题目的答案
        if(null != answers && 0 < answers.length){
            for (String answer : answers){
                String answerStr = answer.split("@#@")[0];
                String flag = answer.split("@#@")[1];
                ObjectiveItemAnswer objectiveItemAnswer = new ObjectiveItemAnswer();
                objectiveItemAnswer.setObjectiveItemId(oldObjectiveItem.getId());
                objectiveItemAnswer.setAnswer(answerStr);
                objectiveItemAnswer.setIsAnswer("1".equals(flag) ? ObjectiveItemAnswer.ISANSWER_YES : ObjectiveItemAnswer.ISANSWER_NOT);
                objectiveItemAnswer.setOperator(loginName);
                addObjectiveItemAnswerService.add(objectiveItemAnswer);
            }
        }
    }
}
