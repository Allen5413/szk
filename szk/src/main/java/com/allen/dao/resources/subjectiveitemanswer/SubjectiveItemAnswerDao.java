package com.allen.dao.resources.subjectiveitemanswer;

import com.allen.entity.resources.SubjectiveItemAnswer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface SubjectiveItemAnswerDao extends CrudRepository<SubjectiveItemAnswer, Long> {
    public List<SubjectiveItemAnswer> findBySubjectiveItemId(long subjectiveItemId)throws Exception;

    @Modifying
    @Query("delete from SubjectiveItemAnswer where subjectiveItemId = ?1")
    public void delBySubjectiveItemId(long subjectiveItemId)throws Exception;
}
