package com.allen.service.resources.objectiveitem.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.objectiveitem.ObjectiveItemDao;
import com.allen.dao.resources.objectiveitemanswer.ObjectiveItemAnswerDao;
import com.allen.entity.resources.ObjectiveItem;
import com.allen.entity.resources.ObjectiveItemAnswer;
import com.allen.service.resources.objectiveitem.EditObjectiveItemService;
import com.allen.util.DateUtil;
import com.allen.util.StringUtil;
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

    @Override
    @Transactional
    public void edit(ObjectiveItem objectiveItem, String[] labels, String delAnswerIds, String[] newAnswers, String loginName) throws Exception {
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

        //删除题目的答案
        if(!StringUtil.isEmpty(delAnswerIds)){
            String[] delAnswerIdsArray = delAnswerIds.split(",");
            if(null != delAnswerIdsArray && 0 < delAnswerIdsArray.length){
                for(String delAnswerId : delAnswerIdsArray){
                    objectiveItemAnswerDao.delete(Long.parseLong(delAnswerId));
                }
            }
        }

        //新增题目的答案
        if(null != newAnswers && 0 < newAnswers.length){
            for (String answer : newAnswers){
                String[] temp = answer.split("@#@");
                ObjectiveItemAnswer objectiveItemAnswer = new ObjectiveItemAnswer();
                objectiveItemAnswer.setObjectiveItemId(oldObjectiveItem.getId());
                objectiveItemAnswer.setAnswer(temp[1]);
                objectiveItemAnswer.setIsAnswer(Integer.parseInt(temp[0]));
                objectiveItemAnswer.setOperator(loginName);
                objectiveItemAnswerDao.save(objectiveItemAnswer);
            }
        }
    }
}
