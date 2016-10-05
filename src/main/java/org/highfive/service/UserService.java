package org.highfive.service;

import org.highfive.domain.UserVO;

public interface UserService {
	
	public void regist(UserVO user) throws Exception;
	public void modify(UserVO user) throws Exception;
	public void delete(String uid) throws Exception;
	public UserVO read(String uid, int flag) throws Exception;
	public boolean checkUser(UserVO user) throws Exception;
	public boolean checkUname(UserVO user) throws Exception;
}
