package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.UserVO;

public interface HighfiveDAO {
	
	public void regist(HighfiveVO hvo);
	public void delete(HighfiveVO hf);
	public int getFlag(HighfiveVO hf) throws Exception;
	public void accept(HighfiveVO hf) throws Exception;
	public List<UserVO> highfiveList(String uid) throws Exception;

	public List<UserVO> sendList(String uid) throws Exception;

	public List<UserVO> receiveList(String uid) throws Exception;
}
