package com.allen.dao.teachplan.teachplansubjectsistudent;

import com.allen.entity.teachplan.TeachPlanSubjectSiStudent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectSiStudentDao extends CrudRepository<TeachPlanSubjectSiStudent, Long> {

    /**
     * 通过学生id和专题关联题目id，查询学生是否做过此题
     * @param userId
     * @param tpssiId
     * @return
     * @throws Exception
     */
    public TeachPlanSubjectSiStudent findByUserIdAndTpssiId(long userId, long tpssiId)throws Exception;

    /**
     * 查询一个专题下的关联的题目，学生答题记录
     * @param tpssiId
     * @return
     * @throws Exception
     */
    public List<TeachPlanSubjectSiStudent> findByTpssiId(long tpssiId)throws Exception;

    /**
     * 删除一道题下面学生的答题记录
     * @param siId
     * @throws Exception
     */
    @Modifying
    @Query(nativeQuery = true, value = "delete t2 from teach_plan_subject_si_student t2, teach_plan_subject_si t3 " +
            "where t2.tpssi_id = t3.id and t3.subjective_item_id = ?1")
    public void delBySiId(long siId)throws Exception;
}
