package com.bookmanage.mapper;

import com.bookmanage.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    Role findActionsByRoleid (int roleid);
}
