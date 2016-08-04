package com.wanzhon.service;

import java.util.List;

import com.wanzhon.model.User;
import com.wanzhon.page.Page;

public interface UserService {
	
	public int insertUser(User user);
	public User findUserById(int id);
	public int deleteUserById(int id);
	public int updateUser(User user);
	public List<User> queryUserList();  
	public User selectUserInfoById(Integer id);
	//PageInfo<User> queryByPage(String userName,Integer pageNo,Integer pageSize);
	public long getAllUserCount();//查询所有的记录数
	public List<User> getUsers(Page page);
	public List<User> getAllUser();
}
