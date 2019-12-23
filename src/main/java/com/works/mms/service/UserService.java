package com.works.mms.service;

import com.works.mms.entity.User;

public interface UserService {

	int findByUsernameAndPassword(User user);

	boolean add(User user);

	int findByUsername(User user);
	
}
