package org.highfive.service;

import java.util.List;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;

public interface ReplyService {

	public void regist(ReplyVO reply) throws Exception;
	public void modify(ReplyVO reply) throws Exception;
	public void delete(ReplyVO reply) throws Exception;
	public List<UserReplyVO> list(int bno) throws Exception;
	public List<UserReplyVO> pageList(ReplyVO reply) throws Exception;
}
