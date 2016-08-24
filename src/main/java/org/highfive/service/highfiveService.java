package org.highfive.service;

import java.util.List;

import org.highfive.domain.highfiveVO;

public interface highfiveService {
	public void regist(highfiveVO high);
	
	public highfiveVO read(Integer hno);

	
	public void delete(Integer hno);
	
	public List<highfiveVO> listAll();
}
