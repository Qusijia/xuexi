package com.bookmanage.mapper;

import com.bookmanage.model.Book;
import com.bookmanage.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User  findRolesByUserid (int userid);

    User find(String name,String password);

    void insertRole( int userId,int[] roleIds);


}
