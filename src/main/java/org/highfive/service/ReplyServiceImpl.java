package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;
import org.highfive.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO replyDao;
	
	@Override
	public void regist(ReplyVO reply) throws Exception {
		replyDao.create(reply);
	}

	@Override
	public void modify(ReplyVO reply) throws Exception {
		replyDao.modify(reply);
	}

	@Override
	public void delete(int rno) throws Exception {
		replyDao.delete(rno);
	}

	@Override
	public List<UserReplyVO> list(int bno) throws Exception {
		return replyDao.list(bno);
	}

}
