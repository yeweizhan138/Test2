package com.wanzhon.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wanzhon.model.User;
import com.wanzhon.service.RoleService;
import com.wanzhon.service.UserService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

public class UserTest {

	private UserService userService;
	private RoleService roleService;
	private static Logger logger = LoggerFactory.getLogger(UserTest.class);
	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml" });
		userService = (UserService) context.getBean("userServiceImpl");
		roleService = (RoleService) context.getBean("roleServiceImpl");
		  
	}

	@Test
	public void addUser() {
		User user = new User();
		user.setUsername("小明");
		user.setPassword("1234");
		System.out.println(userService.insertUser(user));
	}

	@Test
	public void showUserById() {

		System.out.println(userService.findUserById(1));
	}

	@Test
	public void deleteUserById() {
		userService.deleteUserById(4);
	}

	@Test
	public void updateUser() {
		User user = userService.findUserById(3);
		user.setUsername("abc");
		user.setPassword("222");
		userService.updateUser(user);
	}

	@Test
	public void listAll() {

		List<User> list = userService.queryUserList();
		logger.info(JSON.toJSONString(list));
	
	
	}
	@Test
	public void queryUserInfoById(){
		User user = (User) userService.selectUserInfoById(3);
		logger.info(JSON.toJSONString(user));
	}
	
	/*@Test  
    public void queryByPageTest(){  
        PageInfo<User> page =  userService.queryByPage("叶伟展", 1, 1);
        System.out.println(page);
    }*/
}
