package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.UserVO;
import org.highfive.exception.NotExistException;
import org.highfive.persistence.HighfiveDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HighfiveServiceImpl implements HighfiveService {

	@Inject
	private HighfiveDAO hfDao;

	@Transactional
	@Override
	public void regist(HighfiveVO hf) throws Exception {
		hf.setFlag(1);
		hfDao.regist(hf);
		hfDao.regist(swapUser(hf));
	}

	@Transactional
	@Override

	public void delete(HighfiveVO hf) throws Exception {

		hfDao.delete(hf);
		hfDao.delete(swapUser(hf));
	}

	@Transactional
	@Override
	public void accept(HighfiveVO hf) throws Exception {
		hfDao.accept(hf);
		hfDao.accept(swapUser(hf));
	}

	public HighfiveVO swapUser(HighfiveVO hf) {
		HighfiveVO fh = new HighfiveVO();
		fh.setReceiver(hf.getSender());
		fh.setSender(hf.getReceiver());
		fh.setFlag(2);
		return fh;
	}

	@Override
	public List<UserVO> highfiveList(HighfiveVO hf) throws Exception {
		List<UserVO> list = hfDao.highfiveList(hf);
		System.out.println("asdifjasijfiajsfijasifiajsdijsaidjfijsaijfisafijsaifiasjfdiajs" + list.size());
		if(list.size() != 0){
			return list;
		}
		throw new NotExistException();
	}

	@Override
	public List<UserVO> sendList(HighfiveVO hf) throws Exception {
		List<UserVO> list = hfDao.sendList(hf);
		if(list.size() != 0){
			return list;
		}
		throw new NotExistException();
	}

	@Override
	public List<UserVO> receiveList(HighfiveVO hf) throws Exception {
		List<UserVO> list = hfDao.receiveList(hf);
		if(list.size() != 0){
			return list;
		}
		throw new NotExistException();
	}

	@Override
	public int highfiveCheck(HighfiveVO hf) throws Exception {
		return hfDao.highfiveCheck(hf);
	}

}
