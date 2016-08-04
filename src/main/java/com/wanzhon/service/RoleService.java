package com.wanzhon.service;

import java.util.List;

import com.wanzhon.model.Role;
import com.wanzhon.model.User;

public interface RoleService {


	public int insertRole(Role role);
	public Role findRoleById(Integer id);
	public int deleteRoleById(Integer id);
	public int updateRole(Role role);
	public List<User> selectUserByRoleId(Integer id);
} 
