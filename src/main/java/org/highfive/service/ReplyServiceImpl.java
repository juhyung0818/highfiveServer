package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;
import org.highfive.persistence.BoardDAO;
import org.highfive.persistence.ReplyDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private BoardDAO boardDao;
	@Inject
	private ReplyDAO replyDao;
	
	@Transactional
	@Override
	public void regist(ReplyVO reply) throws Exception {
		boardDao.updateReplyCnt(reply.getBno(), 1);
		replyDao.create(reply);
	}

	@Override
	public void modify(ReplyVO reply) throws Exception {
		replyDao.modify(reply);
	}

	@Transactional
	@Override
	public void delete(int rno) throws Exception {
		boardDao.updateReplyCnt(replyDao.getBno(rno), -1);
		replyDao.delete(rno);
	}

	@Override
	public List<UserReplyVO> list(int bno) throws Exception {
		return replyDao.list(bno);
	}

}
