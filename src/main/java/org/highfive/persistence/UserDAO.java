package org.highfive.persistence;

import org.highfive.domain.UserVO;

public interface UserDAO {

	public void register(UserVO user) throws Exception;
	public UserVO read(String uid) throws Exception;
	public void modify(UserVO user) throws Exception;
	public void delete(String user) throws Exception;
}
