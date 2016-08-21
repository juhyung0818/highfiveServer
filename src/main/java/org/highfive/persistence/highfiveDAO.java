package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.highfiveVO;

public interface highfiveDAO {
	
	public void regist(highfiveVO hvo);
	
	public highfiveVO read(Integer hno);
	
	public void delete(Integer hno);
	
	public List<highfiveVO> listAll();
}
