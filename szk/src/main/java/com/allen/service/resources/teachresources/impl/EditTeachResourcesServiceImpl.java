package com.allen.service.resources.teachresources.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.teachresources.TeachResourcesDao;
import com.allen.entity.resources.TeachResources;
import com.allen.service.resources.teachresources.EditTeachResourcesService;
import com.allen.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class EditTeachResourcesServiceImpl implements EditTeachResourcesService {

    @Resource
    private TeachResourcesDao teachResourcesDao;

    @Override
    @Transactional
    public void edit(TeachResources teachResources, String[] labels, String loginName) throws Exception {
        TeachResources teachResources2 = teachResourcesDao.findByName(teachResources.getName());
        if(null != teachResources2 && teachResources2.getId() != teachResources.getId()){
            throw new BusinessException("资源名称："+teachResources.getName()+"，已经存在");
        }
        TeachResources oldTeachResources = teachResourcesDao.findOne(teachResources.getId());
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
            oldTeachResources.setLabelIds(labelIds);
            oldTeachResources.setLabelNames(labelNames);
        }else{
            oldTeachResources.setLabelIds(null);
            oldTeachResources.setLabelNames(null);
        }

        oldTeachResources.setName(teachResources.getName());
        oldTeachResources.setContent(teachResources.getContent());
        oldTeachResources.setIsLink(teachResources.getIsLink());
        oldTeachResources.setOperator(loginName);
        oldTeachResources.setOperateTime(DateUtil.getLongNowTime());
        teachResourcesDao.save(oldTeachResources);
    }
}
