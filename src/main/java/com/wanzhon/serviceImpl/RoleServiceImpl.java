package com.wanzhon.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzhon.dao.RoleMapper;
import com.wanzhon.model.Role;
import com.wanzhon.model.User;
import com.wanzhon.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	/*public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	@Resource
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
*/
	@Override
	public int insertRole(Role role) {
		return this.roleMapper.insert(role);
	}

	@Override
	public int updateRole(Role role) {
		return this.roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public Role findRoleById(Integer id) {
		return this.roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteRoleById(Integer id) {
		return this.roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<User> selectUserByRoleId(Integer id) {

		return this.roleMapper.selectUserByRoleId(id);
	}

}
