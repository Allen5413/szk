package com.allen.service.resources.label.impl;

import com.allen.dao.resources.label.LabelDao;
import com.allen.entity.resources.Label;
import com.allen.service.resources.label.FindLabelForAllService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindLabelForAllServiceImpl implements FindLabelForAllService {

    @Resource
    private LabelDao labelDao;

    @Override
    public List<Label> find() throws Exception {
        return (List<Label>) labelDao.findAll();
    }
}
