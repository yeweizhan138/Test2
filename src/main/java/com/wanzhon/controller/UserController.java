package com.wanzhon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wanzhon.model.User;
import com.wanzhon.page.Page;
import com.wanzhon.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("userList")
	public String index() {
		return "index";
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String pageNow = request.getParameter("pageNow");
		String pageSize = request.getParameter("pageSize");

		Page page = null;

		List<User> users = null;
		int totalCount = (int) userService.getAllUserCount();
		// 如果页面条数为空则默认为6
		if (pageSize == null) {
			pageSize = "6";
		}
		if (pageNow != null && pageNow != "") {
			int pageNowInt = Integer.parseInt(pageNow);
			page = new Page(totalCount, pageNowInt);

			// 如果选择的页码超过最大页码，则自动跳转到最大页码
			if (pageNowInt > page.getTotalPageCount()) {
				pageNowInt = page.getTotalPageCount();
				page.setPageNow(pageNowInt);
			}
		} else {
			page = new Page(totalCount, 1);

		}
		page.setPageSize(Integer.parseInt(pageSize));

		users = userService.getUsers(page);
		model.addAttribute("page", page);
		model.addAttribute("users", users);
		return "list";
	}

	@RequestMapping(value = "/add")
	public String add(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username != null && password != null && username!=""&&password!="") {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userService.insertUser(user);

			List<User> list = null;
			Page page = null;
			int totalCount = (int) userService.getAllUserCount();
			page = new Page(totalCount, 1);
			list = userService.getUsers(page);
			model.addAttribute("page", page);
			model.addAttribute("users", list);
			return "list";
		}else{
			return "addError";
		}
		
		
	}

	@RequestMapping(value = "/detail/{id}")
	public String detail(@PathVariable("id") int id, ModelMap model) {
		System.out.println(id);
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "detail";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id, ModelMap model) {
		userService.deleteUserById(id);
		List<User> list = userService.getAllUser();
		model.addAttribute("users", list);
		return "list";
	}

	@RequestMapping(value = "/toupdate/{id}")
	public String toUpdate(@PathVariable int id, ModelMap model) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "update";
	}

	@RequestMapping(value = "/update")
	public String update(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("sid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);
		userService.updateUser(user);
		List<User> list = userService.getAllUser();
		model.addAttribute("users", list);
		return "list";
	}

}