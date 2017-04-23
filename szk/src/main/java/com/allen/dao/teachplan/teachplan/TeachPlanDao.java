package com.allen.dao.teachplan.teachplan;

import com.allen.entity.teachplan.TeachPlan;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/21 0021.
 */
public interface TeachPlanDao extends CrudRepository<TeachPlan, Long> {
    public TeachPlan findByName(String name);
}
