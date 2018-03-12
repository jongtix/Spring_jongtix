package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.impl.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;
 
	@Override
	public UserVO setUser(UserVO vo){
		return userDao.setUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDao.getUser(vo);
	}

}
