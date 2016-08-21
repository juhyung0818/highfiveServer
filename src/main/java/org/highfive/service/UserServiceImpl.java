package org.highfive.service;

import javax.inject.Inject;

import org.highfive.domain.UserVO;
import org.highfive.persistence.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO userDao;
	
	@Override
	public void regist(UserVO user) throws Exception {
		userDao.regist(user);
	}

	@Override
	public UserVO read(String uid) throws Exception {
		return userDao.read(uid);
	}

	@Override
	public void modify(UserVO user) throws Exception {
		userDao.modify(user);
	}

	@Override
	public void delete(String uid) throws Exception {
		userDao.delete(uid);
	}

	
}
