package org.highfive.service;

import java.util.List;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.UserVO;


public interface HighfiveService {

	public void regist(HighfiveVO hf) throws Exception;
	public void delete(HighfiveVO hf) throws Exception;
	public int getFlag(HighfiveVO hf) throws Exception;
	public void accept(HighfiveVO hf) throws Exception;
	public List<UserVO> highfiveList(String uid) throws Exception;
	public List<UserVO> sendList(String uid) throws Exception;
	public List<UserVO> receiveList(String uid) throws Exception;
}
