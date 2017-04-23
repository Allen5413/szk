package com.allen.service.user.user.impl;

import com.allen.dao.user.user.UserDao;
import com.allen.entity.user.User;
import com.allen.service.user.user.FindStudentListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
@Service
public class FindStudentListServiceImpl implements FindStudentListService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> find() throws Exception {
        return userDao.findByType(User.TYPE_STUDENT);
    }
}
