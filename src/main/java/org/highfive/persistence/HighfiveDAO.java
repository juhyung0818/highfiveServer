package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.HighfiveVO;

public interface HighfiveDAO {
	
	public void regist(HighfiveVO hvo);
	
	public HighfiveVO read(Integer hno);
	
	public void delete(Integer hno);
	
	public List<HighfiveVO> listAll();
}
