package com.allen.service.resources.label.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.resources.label.LabelDao;
import com.allen.entity.resources.Label;
import com.allen.service.resources.label.AddLabelService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/23 0023.
 */
@Service
public class AddLabelServiceImpl implements AddLabelService {

    @Resource
    private LabelDao labelDao;

    @Override
    public Label add(Label label, String loginName) throws Exception {
        Label label2 = labelDao.findByName(label.getName());
        if(null != label2 && !StringUtil.isEmpty(label2.getName())){
            throw new BusinessException("标签："+label.getName()+"，已经存在!");
        }
        label.setCreator(loginName);
        label.setOperator(loginName);
        label = labelDao.save(label);
        return label;
    }
}
