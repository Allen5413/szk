package com.allen.dao.teachplan.teachplanstudent;

import com.allen.entity.teachplan.TeachPlanStudent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachPlanStudentDao extends CrudRepository<TeachPlanStudent, Long> {
    public List<TeachPlanStudent> findByTeachPlanId(long tpId)throws Exception;
}
