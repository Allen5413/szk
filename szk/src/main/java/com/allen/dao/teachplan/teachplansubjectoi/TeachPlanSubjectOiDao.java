package com.allen.dao.teachplan.teachplansubjectoi;

import com.allen.entity.teachplan.TeachPlanSubjectOi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectOiDao extends CrudRepository<TeachPlanSubjectOi, Long> {

    public List<TeachPlanSubjectOi> findByTeachPlanSubjectId(long teachPlanSubjectId)throws Exception;

    public TeachPlanSubjectOi findByTeachPlanSubjectIdAndObjectiveItemId(long teachPlanSubjectId, long objectiveItemId)throws Exception;
}
