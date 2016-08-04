package com.wanzhon.dao;

import java.util.List;

import com.wanzhon.model.Role;
import com.wanzhon.model.User;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<User> selectUserByRoleId(Integer id);//根据Role的Id查询关联的User
}