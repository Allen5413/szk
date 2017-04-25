package com.allen.dao.teachplan.teachplansubjectoi;

import com.allen.entity.teachplan.TeachPlanSubjectOi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectOiDao extends CrudRepository<TeachPlanSubjectOi, Long> {

    public List<TeachPlanSubjectOi> findByTeachPlanSubjectId(long teachPlanSubjectId)throws Exception;

    public TeachPlanSubjectOi findByTeachPlanSubjectIdAndObjectiveItemId(long teachPlanSubjectId, long objectiveItemId)throws Exception;

    /**
     * 删除一道题与专题的关联
     * @param oiId
     * @throws Exception
     */
    @Modifying
    @Query(nativeQuery = true, value = "delete t3 from teach_plan_subject_oi t3 where t3.objective_item_id = ?1")
    public void delByOiId(long oiId)throws Exception;
}
