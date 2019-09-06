package com.kingduns.pertes.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/login")// 请求路径
	public String login() {
		return "login";// 需要返回的页面
	}
	
	@RequestMapping("/register")// 请求路径
	public String register() {
		return "register";// 需要返回的页面
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/user/add")
	public String addUser() {
		return "user/addUser";
	}
	
	@RequestMapping("/user/update")
	public String updateUser() {
		return "user/updateUser";
	}
}