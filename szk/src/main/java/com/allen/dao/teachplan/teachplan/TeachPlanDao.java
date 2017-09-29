package com.allen.dao.teachplan.teachplan;

import com.allen.entity.teachplan.TeachPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/21 0021.
 */
public interface TeachPlanDao extends CrudRepository<TeachPlan, Long> {
    public TeachPlan findByName(String name);
    public List<TeachPlan> findByState(int state)throws Exception;
}
