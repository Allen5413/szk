package com.allen.service.resources.teachresources.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.teachresources.TeachResourcesDao;
import com.allen.entity.resources.TeachResources;
import com.allen.service.resources.teachresources.AddTeachResourcesService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class AddTeachResourcesServiceImpl implements AddTeachResourcesService {

    @Resource
    private TeachResourcesDao teachResourcesDao;

    @Override
    @Transactional
    public void add(TeachResources teachResources, String[] labels, String loginName) throws Exception {
        TeachResources teachResources2 = teachResourcesDao.findByName(teachResources.getName());
        if(null != teachResources2 && !StringUtil.isEmpty(teachResources2.getName())){
            throw new BusinessException("题目名称："+teachResources.getName()+"，已经存在");
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
            teachResources.setLabelIds(labelIds);
            teachResources.setLabelNames(labelNames);
        }
        teachResources.setCreator(loginName);
        teachResources.setOperator(loginName);
        teachResourcesDao.save(teachResources);
    }
}
