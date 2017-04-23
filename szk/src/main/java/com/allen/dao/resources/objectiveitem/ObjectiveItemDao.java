package com.allen.dao.resources.objectiveitem;

import com.allen.entity.resources.ObjectiveItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface ObjectiveItemDao extends CrudRepository<ObjectiveItem, Long> {
    public ObjectiveItem findByName(String name);
}
