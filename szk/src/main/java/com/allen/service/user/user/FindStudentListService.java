package com.allen.service.user.user;

import com.allen.entity.user.User;

import java.util.List;

/**
 * Created by Allen on 2017/4/22 0022.
 */
public interface FindStudentListService {
    public List<User> find()throws Exception;
}
