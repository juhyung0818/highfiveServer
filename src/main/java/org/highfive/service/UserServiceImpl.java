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
	public UserVO read(String uid, int flag) throws Exception {
		return userDao.read(uid, flag);
	}

	@Override
	public void modify(UserVO user) throws Exception {
		userDao.modify(user);
	}

	@Override
	public void delete(String uid) throws Exception {
		userDao.delete(uid);
	}

	
	//already user: true
	//new user : false
	@Override
	public boolean checkUser(UserVO user) throws Exception {
		try{
			if(userDao.checkUser(user).equals(user.getUid())){
				return true;
			}
			return false;
		} catch(NullPointerException e){
			return false;
		}
	}
	
	//already name: true
	//new name : false
	@Override
	public boolean checkUname(UserVO user) throws Exception {
		try{
			if(userDao.checkUname(user).equals(user.getUname())){
				return true;
			}
			return false;
		} catch(NullPointerException e){
			return false;
		}
	}

	
}
