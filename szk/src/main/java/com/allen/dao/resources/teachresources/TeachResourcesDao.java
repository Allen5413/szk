package com.allen.dao.resources.teachresources;

import com.allen.entity.resources.TeachResources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface TeachResourcesDao extends CrudRepository<TeachResources, Long> {
    public TeachResources findByName(String name);

    /**
     * 查询一个专题下管理的资源信息
     * @param tpsId
     * @return
     * @throws Exception
     */
    @Query("select tr from TeachResources tr, TeachPlanSubjectResources t " +
            "where tr.id = t.resourcesId and t.teachPlanSubjectId = ?1 " +
            "order by tr.id")
    public List<TeachResources> findByTpsId(long tpsId)throws Exception;
}
