package com.kingduns.pertes.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingduns.pertes.common.bean.User;
import com.kingduns.pertes.user.service.UserService;

/**
 * 自定义Realm
 * 
 * @author Administrator
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//	给资源进行授权
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//	添加授权的字符串
		simpleAuthorizationInfo.addStringPermission("user:addUser");
		return simpleAuthorizationInfo;
	}

	/**
	 * 执行认证逻辑（认证用户名和密码）
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1、获取前端页面传过来的用户数据
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		System.out.println(usernamePasswordToken.getPassword());
		// 2、查询数据库
		User user = userService.getUserByAccountNumber(usernamePasswordToken.getUsername());
		if (user == null) {
			// 用户不存在返回null，shiro会报UnknownAccountException
			return null;
		} else {
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			return simpleAuthenticationInfo;
		}
	}

}
