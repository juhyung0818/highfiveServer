package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;

public interface ReplyDAO {

	public void regist(ReplyVO reply) throws Exception;
	public List<UserReplyVO> list(int bno) throws Exception;
	public void modify(ReplyVO reply) throws Exception;
	public void delete(ReplyVO replt) throws Exception;
	public int getBno(int rno) throws Exception;
}
