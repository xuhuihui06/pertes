package com.kingduns.pertes.user.service.impl;

import java.util.Date;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kingduns.pertes.common.bean.User;
import com.kingduns.pertes.common.mapper.UserMapper;
import com.kingduns.pertes.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUser(String accountNumber, String passWord) {
		User user = null;
		if (accountNumber != null && !accountNumber.isEmpty() && passWord != null && !passWord.isEmpty()) {
			user = userMapper.queryUserByAccountNumberAndPassWord(accountNumber, passWord);
		}
		return user;
	}

	@Override
	public User getUserByAccountNumber(String accountNumber) {
		User user = null;
		if (accountNumber != null && !accountNumber.isEmpty()) {
			user = userMapper.queryUserByAccountNumber(accountNumber);
		}
		return user;
	}

	@Override
	public Integer addUser(User user) {
		if (user != null) {
			// 对密码进行加密
			user.setPassword(
					new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), 2)
							.toHex());
			user.setId(UUID.randomUUID().toString().replace("_", ""));
			user.setDelflg(1);
			user.setIsMember(0);
			user.setCreTime(new Date());
			user.setMaxManageNum(1000);
			return userMapper.insertSelective(user);
		}
		return null;
	}

}
