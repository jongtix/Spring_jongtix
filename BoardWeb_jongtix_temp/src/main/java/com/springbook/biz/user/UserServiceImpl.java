package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.impl.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	UserDAO dao = new UserDAO();

	@Override
	public void setUser(UserVO vo) {
		dao.setUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

}
