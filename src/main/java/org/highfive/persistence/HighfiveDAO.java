package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.UserVO;

public interface HighfiveDAO {

	public void regist(HighfiveVO hf) throws Exception;
	public void delete(HighfiveVO hf) throws Exception;
	public void accept(HighfiveVO hf) throws Exception;
	public List<UserVO> highfiveList(HighfiveVO hf) throws Exception;
	public List<UserVO> sendList(HighfiveVO hf) throws Exception;
	public List<UserVO> receiveList(HighfiveVO hf) throws Exception;
	public int highfiveCheck(HighfiveVO hf) throws Exception;
}
