package com.wanzhon.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.wanzhon.model.Role;
import com.wanzhon.model.User;
import com.wanzhon.service.RoleService;
import com.wanzhon.service.UserService;

public class RoleTest {

	private RoleService roleService;
	private UserService userService;
	private static Logger logger = LoggerFactory.getLogger(UserTest.class);
	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml" });
		roleService = (RoleService) context.getBean("roleServiceImpl");
		userService = (UserService) context.getBean("userServiceImpl");
	}

	@Test
	public void addRole() {
		User user = userService.findUserById(2);
		Role role = new Role();
		role.setName("tt");
		role.setUserid(user.getId());
		System.out.println(roleService.insertRole(role));
		
		Role role1 = new Role();
		role1.setName("BB");
		role1.setUserid(user.getId());
		System.out.println(roleService.insertRole(role1));

	}
	@Test
	public void findRole() {
		
		System.out.println(roleService.findRoleById(2));

	}
	@Test
	public void deleteRole(){
		System.out.println(roleService.deleteRoleById(1));
	}
	
	@Test
	public void updateRole(){
		Role role = roleService.findRoleById(2);
		
		roleService.updateRole(role);
	}
	@Test
	public void queryUserByRoleId(){
		
		List<User> list = roleService.selectUserByRoleId(2);
		logger.info(JSON.toJSONString(list));
	}
	
}
