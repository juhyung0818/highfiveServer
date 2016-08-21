package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.highfiveVO;
import org.highfive.persistence.highfiveDAO;
import org.springframework.stereotype.Service;
@Service
public class highfiveServiceImpl implements highfiveService{

	@Inject
	private highfiveDAO hdao;
	@Override
	public void regist(highfiveVO high) {
		hdao.regist(high);
	}

	@Override
	public highfiveVO read(Integer hno) {
		return hdao.read(hno);
	}

	@Override
	public void remove(Integer hno) {
		hdao.delete(hno);
	}

	@Override
	public List<highfiveVO> listAll() {
		return hdao.listAll();
	}

}
