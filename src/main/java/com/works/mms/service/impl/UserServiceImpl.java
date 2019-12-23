package com.works.mms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.works.mms.dao.UserMapper;
import com.works.mms.entity.User;
import com.works.mms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int findByUsernameAndPassword(User user) {
		User temp = userMapper.selectByUsernameAndPassword(user);
		return temp == null ? 0 : temp.getId();
	}

	@Override
	public int findByUsername(User user) {
		User temp = userMapper.selectByUsername(user);
		return temp == null ? 0 : temp.getId();
	}

	@Override
	public boolean add(User user) {
		int rows = userMapper.insert(user);
		return rows > 0 ? true : false;
	}


}
