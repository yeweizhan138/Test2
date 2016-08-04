package com.wanzhon.serviceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanzhon.dao.UserMapper;
import com.wanzhon.model.User;
import com.wanzhon.page.Page;
import com.wanzhon.service.UserService;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserMapper userMapper;

	/*public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}*/

	@Override
	public int insertUser(User user) {
		return this.userMapper.insert(user);

	}

	@Override
	public User findUserById(int id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteUserById(int id) {
		return this.userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateUser(User user) {
		return this.userMapper.updateByPrimaryKey(user);
	}

	@Override
	public List<User> queryUserList() {

		return this.userMapper.queryForList();
	}

	@Override
	public User selectUserInfoById(Integer id) {

		return this.userMapper.selectUserInfoById(id);
	}

	/*@Override
	public PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<User> list = userMapper.selectUserByUsername(userName);
		// 用PageInfo对结果进行包装
		PageInfo<User> page = new PageInfo<User>(list);
		// 测试PageInfo全部属性
System.out.println(page.getPageNum());
System.out.println(page.getPageSize());
System.out.println(page.getStartRow());
System.out.println(page.getEndRow());
System.out.println(page.getTotal());
System.out.println(page.getPages());
System.out.println(page.getFirstPage());
System.out.println(page.getLastPage());
System.out.println(page.isHasPreviousPage());
System.out.println(page.isHasNextPage());
		return page;
	}*/

	@Override
	public long getAllUserCount() {
		return this.userMapper.getAllUserCount();
	}

	@Override
	public List<User> getUsers(Page page) {
		
		return this.userMapper.getUsers(page);
	}

	@Override
	public List<User> getAllUser() {
		return this.userMapper.getAllUser();
	}

}
