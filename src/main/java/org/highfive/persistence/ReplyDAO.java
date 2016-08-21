package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;

public interface ReplyDAO {

	public void create(ReplyVO reply) throws Exception;
	public List<UserReplyVO> list(int bno) throws Exception;
	public void modify(ReplyVO reply) throws Exception;
	public void delete(int rno) throws Exception;
}
