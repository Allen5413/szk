package com.allen.dao.teachplan.teachplansubject;

import com.allen.entity.teachplan.TeachPlanSubject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectDao extends CrudRepository<TeachPlanSubject, Long> {

    public TeachPlanSubject findByName(String name);

}
