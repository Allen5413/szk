package com.allen.dao.resources.label;

import com.allen.entity.resources.Label;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface LabelDao extends CrudRepository<Label, Long> {
    public Label findByName(String name)throws Exception;
}
