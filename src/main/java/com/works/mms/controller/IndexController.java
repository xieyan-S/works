package com.works.mms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//显示login页面
	@RequestMapping("/login")
	public String login() {
		//System.out.println("跳转到login");
		return "login.html";
	}
	
	//显示register页面
	@RequestMapping("/register")
	public String register() {
		//System.out.println("跳转到register");
		return "register.html";
	}
	
	//显示index页面
	@RequestMapping("/index")
	public String index() {
		//System.out.println("跳转到index");
		return "index.html";
	}
	
}
