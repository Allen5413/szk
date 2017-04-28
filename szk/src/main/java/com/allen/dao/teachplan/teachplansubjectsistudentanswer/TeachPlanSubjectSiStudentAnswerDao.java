package com.allen.dao.teachplan.teachplansubjectsistudentanswer;

import com.allen.entity.teachplan.TeachPlanSubjectSiStudentAnswer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectSiStudentAnswerDao extends CrudRepository<TeachPlanSubjectSiStudentAnswer, Long> {

    /**
     * 删除一道题下面学生的答题点评记录
     * @param siId
     * @throws Exception
     */
    @Modifying
    @Query(nativeQuery = true, value = "delete t from teach_plan_subject_si_student_answer t, teach_plan_subject_si_student t2, teach_plan_subject_si t3 " +
            "where t.tpssis_id = t2.id and t2.tpssi_id = t3.id and t3.subjective_item_id = ?1")
    public void delBySiId(long siId)throws Exception;
}
