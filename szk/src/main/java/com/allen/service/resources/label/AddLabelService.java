package com.allen.service.resources.label;

import com.allen.entity.resources.Label;

/**
 * Created by Allen on 2017/4/23 0023.
 */
public interface AddLabelService {
    public Label add(Label label, String loginName)throws Exception;
}
