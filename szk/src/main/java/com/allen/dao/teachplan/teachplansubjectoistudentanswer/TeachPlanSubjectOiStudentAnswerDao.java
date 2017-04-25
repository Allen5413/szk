package com.allen.dao.teachplan.teachplansubjectoistudentanswer;

import com.allen.entity.teachplan.TeachPlanSubjectOiStudentAnswer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectOiStudentAnswerDao extends CrudRepository<TeachPlanSubjectOiStudentAnswer, Long> {

    /**
     * 删除一道题下面学生的选择记录
     * @param oiId
     * @throws Exception
     */
    @Modifying
    @Query(nativeQuery = true, value = "delete t from teach_plan_subject_oi_student_answer t, teach_plan_subject_oi_student t2, teach_plan_subject_oi t3\n" +
            "where t.tpsois_id = t2.id and t2.tpsoi_id = t3.id and t3.objective_item_id = ?1")
    public void delByOiId(long oiId)throws Exception;
}
