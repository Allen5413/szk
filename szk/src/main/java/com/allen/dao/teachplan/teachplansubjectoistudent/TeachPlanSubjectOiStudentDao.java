package com.allen.dao.teachplan.teachplansubjectoistudent;

import com.allen.entity.teachplan.TeachPlanSubjectOiStudent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanSubjectOiStudentDao extends CrudRepository<TeachPlanSubjectOiStudent, Long> {

    /**
     * 通过学生id和专题关联题目id，查询学生是否做过此题
     * @param userId
     * @param tpsoiId
     * @return
     * @throws Exception
     */
    public TeachPlanSubjectOiStudent findByUserIdAndTpsoiId(long userId, long tpsoiId)throws Exception;

    /**
     * 查询一个专题下的关联的题目，答对的学生或者答错的学生记录
     * @param tpsoiId
     * @param isRight
     * @return
     * @throws Exception
     */
    public List<TeachPlanSubjectOiStudent> findByTpsoiIdAndIsRight(long tpsoiId, int isRight)throws Exception;

    /**
     * 查询一个专题下的关联的题目，学生答题记录
     * @param tpsoiId
     * @return
     * @throws Exception
     */
    public List<TeachPlanSubjectOiStudent> findByTpsoiId(long tpsoiId)throws Exception;
}
