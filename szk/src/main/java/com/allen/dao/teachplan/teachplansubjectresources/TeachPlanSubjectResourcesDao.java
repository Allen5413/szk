package com.allen.dao.teachplan.teachplansubjectresources;

import com.allen.entity.teachplan.TeachPlanSubjectResources;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectResourcesDao extends CrudRepository<TeachPlanSubjectResources, Long> {

    public List<TeachPlanSubjectResources> findByTeachPlanSubjectId(long teachPlanSubjectId)throws Exception;

    public TeachPlanSubjectResources findByTeachPlanSubjectIdAndResourcesId(long teachPlanSubjectId, long resourcesId)throws Exception;

    /**
     * 删除一道题与专题的关联
     * @param resourcesId
     * @throws Exception
     */
    @Modifying
    @Query(nativeQuery = true, value = "delete t from teach_plan_subject_resources t where t.resources_id = ?1")
    public void delByResourcesId(long resourcesId)throws Exception;
}
