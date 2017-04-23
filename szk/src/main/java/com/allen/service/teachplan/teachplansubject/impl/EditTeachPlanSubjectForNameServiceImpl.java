package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectForNameService;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class EditTeachPlanSubjectForNameServiceImpl implements EditTeachPlanSubjectForNameService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;
    @Resource
    private EditTeachPlanSubjectService editTeachPlanSubjectService;

    public void edit(long id, String name, String loginName)throws Exception{
        TeachPlanSubject teachPlanSubject = teachPlanSubjectDao.findOne(id);
        teachPlanSubject.setName(name);
        editTeachPlanSubjectService.edit(teachPlanSubject, loginName);
    }
}
