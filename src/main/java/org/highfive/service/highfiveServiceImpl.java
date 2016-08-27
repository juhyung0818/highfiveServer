package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
//<<<<<<< HEAD
//=======
import org.highfive.domain.UserVO;
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5
import org.highfive.persistence.HighfiveDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
//public class HighfiveServiceImpl implements HighfiveService{
public class highfiveServiceImpl implements highfiveService{
	@Inject
//<<<<<<< HEAD
//	private HighfiveDAO hdao;
//	@Override
//	public void regist(HighfiveVO high) {
//		hdao.regist(high);
//=======
	private HighfiveDAO hfDao;
	
	@Transactional
	@Override
	public void regist(HighfiveVO hf) {
		hf.setFlag(1);
		hfDao.regist(hf);
		hfDao.regist(swapUser(hf));
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5
	}

	@Transactional
	@Override
//<<<<<<< HEAD
//	public HighfiveVO read(Integer hno) {
//		return hdao.read(hno);
//=======
	public void delete(HighfiveVO hf) {
		hfDao.delete(hf);
		hfDao.delete(swapUser(hf));
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5
	}

	@Override
	public int getFlag(HighfiveVO hf) throws Exception {
		return hfDao.getFlag(hf);
	}

	@Transactional
	@Override
//<<<<<<< HEAD
//	public List<HighfiveVO> listAll() {
//		return hdao.listAll();
//=======
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
	public List<UserVO> highfiveList(String uid) throws Exception {
		return hfDao.highfiveList(uid);
	}

	@Override
	public List<UserVO> sendList(String uid) throws Exception {
		return hfDao.sendList(uid);
	}

	@Override
	public List<UserVO> receiveList(String uid) throws Exception {
		return hfDao.receiveList(uid);
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5
	}

}
