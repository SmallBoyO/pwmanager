package com.zhanghe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanghe.mapper.UserMapper;
import com.zhanghe.model.User;
import com.zhanghe.service.UserService;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public User getUserByUserName( String userName ) {
		User user = new User();
		user.setUserName(userName);
		return userMapper.selectOne(user);
	}

}
