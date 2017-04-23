package com.allen.dao.resources.objectiveitemanswer;

import com.allen.entity.resources.ObjectiveItemAnswer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface ObjectiveItemAnswerDao extends CrudRepository<ObjectiveItemAnswer, Long> {
    public List<ObjectiveItemAnswer> findByObjectiveItemId(long objectiveItemId)throws Exception;

    @Modifying
    @Query("delete from ObjectiveItemAnswer where objectiveItemId = ?1")
    public void delByObjectiveItemId(long objectiveItemId)throws Exception;
}
