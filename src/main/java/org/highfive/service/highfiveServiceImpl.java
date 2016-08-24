package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.persistence.highfiveDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class highfiveServiceImpl implements highfiveService{

	@Inject
	private highfiveDAO hfDao;
	
	@Transactional
	@Override
	public void regist(HighfiveVO hf) {
		hf.setFlag(1);
		hfDao.regist(hf);
		hfDao.regist(swapUser(hf));
	}

	@Transactional
	@Override
	public void delete(HighfiveVO hf) {
		hfDao.delete(hf.getReceiver(), hf.getSender());
		hfDao.delete(hf.getSender(), hf.getReceiver());
	}

	@Override
	public int getFlag(HighfiveVO hf) throws Exception {
		return hfDao.getFlag(hf);
	}

	@Transactional
	@Override
	public void accept(HighfiveVO hf) throws Exception {
		hfDao.accept(hf);
		hfDao.accept(swapUser(hf));
	}
	
	public HighfiveVO swapUser(HighfiveVO hf){
		HighfiveVO fh = new HighfiveVO();
		fh.setReceiver(hf.getSender());
		fh.setSender(hf.getReceiver());
		fh.setFlag(2);
		return fh;
	}

	@Override
	public List<HighfiveVO> highfiveList(String uid) throws Exception {
		return null;
	}

	@Override
	public List<HighfiveVO> sendList(String uid) throws Exception {
		return null;
	}

	@Override
	public List<HighfiveVO> receiveList(String uid) throws Exception {
		return null;
	}

}
