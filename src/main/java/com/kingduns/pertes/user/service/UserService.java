package com.kingduns.pertes.user.service;

import com.kingduns.pertes.common.bean.User;

public interface UserService {

	/**
	 * 根据账号密码查询登录信息
	 * 
	 * @param accountNumber 账号
	 * @param passWord      密码
	 * @return 用户信息
	 */
	User queryUser(String accountNumber, String passWord);
	
	/**
	 * 根据账号密码查询登录信息
	 * 
	 * @param accountNumber 账号
	 * @param passWord      密码
	 * @return 用户信息
	 */
	User getUserByAccountNumber(String accountNumber);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	Integer addUser(User user);
}
