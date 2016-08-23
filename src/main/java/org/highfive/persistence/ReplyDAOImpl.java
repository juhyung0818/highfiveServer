package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Inject
	private SqlSession session;
	private String namespace = "org.highfive.mapper.ReplyMapper";
	
	@Override
	public void regist(ReplyVO reply) throws Exception {
		session.insert(namespace+".regist", reply);
	}

	@Override
	public List<UserReplyVO> list(int bno) throws Exception {
		return session.selectList(namespace+".list", bno);
	}

	@Override
	public void modify(ReplyVO reply) throws Exception {
		session.update(namespace+".modify", reply);
	}

	@Override
	public void delete(int rno) throws Exception {
		//TODO add parameter (string)uid
		session.delete(namespace+".delete", rno);
	}

	@Override
	public int getBno(int rno) throws Exception {
		return session.selectOne(namespace+".getBno", rno);
	}

	
}
