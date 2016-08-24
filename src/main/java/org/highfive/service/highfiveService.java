package org.highfive.service;

import java.util.List;

import org.highfive.domain.HighfiveVO;

public interface highfiveService {
	public void regist(HighfiveVO hf);
	public void delete(HighfiveVO hf);
	public int  getFlag(HighfiveVO hf) throws Exception;
	public void accept(HighfiveVO hf) throws Exception;
	public List<HighfiveVO> highfiveList(String uid) throws Exception;
	public List<HighfiveVO> sendList(String uid) throws Exception;
	public List<HighfiveVO> receiveList(String uid) throws Exception;
}
