package com.allen.service.user.user.impl;

import com.allen.dao.user.user.UserDao;
import com.allen.entity.user.User;
import com.allen.service.user.user.FindUserByZzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2017/4/21 0021.
 */
@Service
public class FindUserByZzServiceImpl implements FindUserByZzService {

    @Resource
    private UserDao userDao;

    @Override
    public User find(String zz) throws Exception {
        return userDao.findByZz(zz);
    }
}
