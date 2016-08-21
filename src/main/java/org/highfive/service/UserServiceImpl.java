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
		// TODO permission check
		return userDao.read(uid);
	}

	@Override
	public void modify(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		userDao.modify(user);
	}

	@Override
	public void remove(String uid) throws Exception {
		// TODO Auto-generated method stub
		userDao.delete(uid);
	}

	
}
