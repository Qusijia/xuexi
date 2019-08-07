package com.bookmanage.service.impl;

import com.bookmanage.mapper.UserMapper;
import com.bookmanage.model.User;
import com.bookmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findRolesByUserid(int userid) {
        return userMapper.findRolesByUserid(userid);
    }

    @Override
    public User find(String name, String password) {
        return userMapper.find(name,password);
    }

    @Override
    public void insertRole(int userId, int[] roleIds) {
        userMapper.insertRole(userId,roleIds);
    }
}
