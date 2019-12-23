package com.works.mms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.works.mms.entity.User;
import com.works.mms.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	//用户登录
	@RequestMapping("/userLogin")
	public String userLogin(User user,Model model) {
		System.out.println(user);
		int userId = userService.findByUsernameAndPassword(user);
		//登录成功
		if(userId!=0)
		{
			user.setId(userId);
			session.setAttribute("user", user);
			return "redirect:/manage";
		}
		//登录失败
		else
		{
			model.addAttribute("message", "用户名或密码输入错误");
			return "login.html";
		}
	}

	//用户注册
	@RequestMapping("/userRegister")
	public String userRegister(User user,String confirmpwd,Model model) {
		System.out.println(user);
		System.out.println(confirmpwd);
		//校验password和confirmpwd是否一致
		if(user.getPassword().equals(confirmpwd))
		{
			//检验用户名是否已存在
			int exist = userService.findByUsername(user);
			if(exist != 0) 
			{
				model.addAttribute("message", "用户名已经存在");
				return "register.html";
			}
			boolean success = userService.add(user);;
			if(success)
			{
				return "register-success.html";
			}
			else
			{
				model.addAttribute("message", "注册失败");
				return "register.html";
			}
		}
		else
		{
			model.addAttribute("message", "两次密码输入不一致");
			return "register.html";
		}
	}
	
	//用户注销
	@RequestMapping("/logout")
	public String logout() {
		if(session.getAttribute("user")!=null) {
			session.removeAttribute("user");
		}
		return "login.html";
	}
	
}
