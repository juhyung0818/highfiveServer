package org.highfive.service;

import javax.inject.Inject;

import org.highfive.domain.UserVO;
import org.highfive.persistence.UserDAO;

public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO userDao;
	
	@Override
	public void regist(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		user.setUid("user01");
		user.setUname("hello");
		user.setAge(1993);
		user.setNation("kr");
		user.setSex(0); //male=0, female=1
		user.setUphoto("default path");
		user.setEmail("@address");
		userDao.register(user);
	}

	@Override
	public UserVO read(String uid) throws Exception {
		// TODO Auto-generated method stub
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
