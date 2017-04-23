package com.allen.service.user.user.impl;

import com.allen.base.exception.BusinessException;
import com.allen.dao.user.user.UserDao;
import com.allen.entity.user.User;
import com.allen.service.user.user.AddTeacherService;
import com.allen.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2016/12/20.
 */
@Service
public class AddTeacherServiceImpl implements AddTeacherService {

    @Resource
    private UserDao userDao;

    @Override
    public void add(String zz, String name, String loginName) throws Exception {
        User user2 = userDao.findByZz(zz);
        if(null != user2 && !StringUtil.isEmpty(user2.getName())){
            throw new BusinessException("ZZ号："+zz+"，已经存在!");
        }
        User user = new User();
        user.setZz(zz);
        user.setName(name);
        user.setState(User.STATE_ENABLE);
        user.setType(User.TYPE_TEACHER);
        user.setCreator(loginName);
        user.setOperator(loginName);
        userDao.save(user);
    }
}
