package org.highfive.service;

import java.util.List;

import org.highfive.domain.HighfiveVO;

public interface highfiveService {
	public void regist(HighfiveVO high);
	
	public HighfiveVO read(Integer hno);

	
	public void delete(Integer hno);
	
	public List<HighfiveVO> listAll();
}
