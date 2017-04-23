package com.allen.service.teachplan.teachplansubject.impl;

import com.allen.dao.teachplan.teachplansubject.TeachPlanSubjectDao;
import com.allen.entity.teachplan.TeachPlanSubject;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectForStateService;
import com.allen.service.teachplan.teachplansubject.EditTeachPlanSubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class EditTeachPlanSubjectForStateServiceImpl implements EditTeachPlanSubjectForStateService {

    @Resource
    private TeachPlanSubjectDao teachPlanSubjectDao;
    @Resource
    private EditTeachPlanSubjectService editTeachPlanSubjectService;

    @Override
    public void edit(long id, int state, String loginName) throws Exception {
        TeachPlanSubject teachPlanSubject = teachPlanSubjectDao.findOne(id);
        teachPlanSubject.setState(state);
        editTeachPlanSubjectService.edit(teachPlanSubject, loginName);
    }
}
