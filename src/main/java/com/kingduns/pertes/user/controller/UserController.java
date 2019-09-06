package com.kingduns.pertes.user.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kingduns.pertes.common.bean.User;
import com.kingduns.pertes.config.bean.ReturnBean;
import com.kingduns.pertes.user.service.UserService;

/**
 * 用户登录相关业务
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("rsat/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * 
	 * @param accountNumber 账号
	 * @param passWord      密码
	 * @return
	 */
	@PostMapping("queryUser")
	public ReturnBean<User> queryUser(String accountNumber, String passWord) {
		// 1、获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		// 2、封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(accountNumber, passWord);
		// 3、执行登录方法
		try {// 若没有出现异常，则登陆成功！
			subject.login(token);
			return new ReturnBean<User>(ReturnBean.SUCCESS, "登录成功！", null);
		} catch (UnknownAccountException e) {
			//	用户名不存在
			return new ReturnBean<User>(ReturnBean.FAIL, "登录失败，该用户名不存在！", null);
		} catch (IncorrectCredentialsException e) {
			//	密码错误
			return new ReturnBean<User>(ReturnBean.FAIL, "登录失败，密码错误！", null);
		}
	}
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("addUser")
	public ReturnBean<Integer> addUser(User user) {
		Integer id = userService.addUser(user);
		if(id != null) {
			return new ReturnBean<Integer>(ReturnBean.SUCCESS, "注册成功！", id);
		}
		return new ReturnBean<Integer>(ReturnBean.SUCCESS, "注册失败！", null);
	}
}
