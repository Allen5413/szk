package com.allen.service.user.user.impl;

import com.allen.dao.user.user.UserDao;
import com.allen.entity.user.User;
import com.allen.service.user.user.FindTeacherListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Service
public class FindTeacherListServiceImpl implements FindTeacherListService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> find() throws Exception {
        return userDao.findByType(User.TYPE_TEACHER);
    }
}
