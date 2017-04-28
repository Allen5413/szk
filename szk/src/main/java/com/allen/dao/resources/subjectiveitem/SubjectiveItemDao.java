package com.allen.dao.resources.subjectiveitem;

import com.allen.entity.resources.SubjectiveItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface SubjectiveItemDao extends CrudRepository<SubjectiveItem, Long> {
    public SubjectiveItem findByName(String name);
}
