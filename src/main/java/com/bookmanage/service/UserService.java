package com.bookmanage.service;

import com.bookmanage.model.User;

public interface UserService {
    User findRolesByUserid (int userid);

    User find(String name,String password);

    void insertRole( int userId,int[] roleIds);
}
