package com.tjudream.demo.service.impl;

import com.tjudream.demo.dao.UserDao;
import com.tjudream.demo.model.User;
import com.tjudream.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * <p>
 * Created by mengxiansen on 2018-04-08 14:15
 *
 * @author mengxs@lenovocloud.com
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
