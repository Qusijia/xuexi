package com.bookmanage.service.impl;

import com.bookmanage.mapper.RoleMapper;
import com.bookmanage.model.Role;
import com.bookmanage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role findActionsByRoleid(int roleid) {
        return roleMapper.findActionsByRoleid(roleid);
    }
}
