package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;
import org.highfive.exception.NotExistException;
import org.highfive.persistence.BoardDAO;
import org.highfive.persistence.ReplyDAO;
import org.junit.runner.manipulation.NoTestsRemainException;
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
		replyDao.regist(reply);
	}

	@Override
	public void modify(ReplyVO reply) throws Exception {
		replyDao.modify(reply);
	}

	@Transactional
	@Override
	public void delete(ReplyVO reply) throws Exception {
		boardDao.updateReplyCnt(replyDao.getBno(reply.getRno()), -1);
		replyDao.delete(reply);
	}

	@Override
	public List<UserReplyVO> list(int bno) throws Exception {
		int temp=0;
		temp=replyDao.getBno(bno);
		if(temp!=0)
		{
			return replyDao.list(bno);
		}
		else
		{
			throw new NotExistException();
		}
	}

}
