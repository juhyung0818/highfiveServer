package org.highfive.service;

import org.highfive.domain.UserVO;

public interface UserService {
	
	public void regist(UserVO user) throws Exception;
	public UserVO read(String uid) throws Exception;
	public void modify(UserVO user) throws Exception;
	public void remove(String uid) throws Exception;
	
}
