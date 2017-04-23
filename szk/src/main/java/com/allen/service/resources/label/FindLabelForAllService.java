package com.allen.service.resources.label;

import com.allen.entity.resources.Label;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface FindLabelForAllService{
    public Iterable<Label> find()throws Exception;
}
