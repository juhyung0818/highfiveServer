package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.persistence.HighfiveDAO;
import org.springframework.stereotype.Service;
@Service
public class highfiveServiceImpl implements highfiveService{

	@Inject
	private HighfiveDAO hdao;
	@Override
	public void regist(HighfiveVO high) {
		hdao.regist(high);
	}

	@Override
	public HighfiveVO read(Integer hno) {
		return hdao.read(hno);
	}

	@Override
	public void delete(Integer hno) {
		hdao.delete(hno);
	}

	@Override
	public List<HighfiveVO> listAll() {
		return hdao.listAll();
	}

}
