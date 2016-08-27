package org.highfive.service;

import java.util.List;

import org.highfive.domain.HighfiveVO;
//<<<<<<< HEAD
//
//public interface highfiveService {
//	public void regist(HighfiveVO high);
//	
//	public HighfiveVO read(Integer hno);
//
//	
//	public void delete(Integer hno);
//	
//	public List<HighfiveVO> listAll();
//=======
import org.highfive.domain.UserVO;

//public interface HighfiveService {
public interface highfiveService {
	public void regist(HighfiveVO hf);
	public void delete(HighfiveVO hf);
	public int  getFlag(HighfiveVO hf) throws Exception;
	public void accept(HighfiveVO hf) throws Exception;
	public List<UserVO> highfiveList(String uid) throws Exception;
	public List<UserVO> sendList(String uid) throws Exception;
	public List<UserVO> receiveList(String uid) throws Exception;
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5
}
