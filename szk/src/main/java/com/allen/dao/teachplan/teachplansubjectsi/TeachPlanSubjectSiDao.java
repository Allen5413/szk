package com.allen.dao.teachplan.teachplansubjectsi;

import com.allen.entity.teachplan.TeachPlanSubjectSi;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectSiDao extends CrudRepository<TeachPlanSubjectSi, Long> {

    public List<TeachPlanSubjectSi> findByTeachPlanSubjectId(long teachPlanSubjectId)throws Exception;

    public TeachPlanSubjectSi findByTeachPlanSubjectIdAndSubjectiveItemId(long teachPlanSubjectId, long subjectiveItemId)throws Exception;

    /**
     * 删除一道题与专题的关联
     * @param siId
     * @throws Exception
     */
    @Modifying
    @Query(nativeQuery = true, value = "delete t3 from teach_plan_subject_si t3 where t3.subjective_item_id = ?1")
    public void delBySiId(long siId)throws Exception;
}
