package org.highfive.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.BoardVO;
import org.highfive.domain.ReplyVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.domain.UserReplyVO;
import org.highfive.exception.NotAuthoriedException;
import org.highfive.exception.NotExistException;
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
	public void delete(ReplyVO reply) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("rno", reply.getRno());
		paramMap.put("uid", reply.getUid());

		try {
			//check if it occur null point exception 
			session.selectOne(namespace+".getRno", paramMap).equals("");
			session.delete(namespace+".delete", paramMap);
		} catch (NullPointerException e) {
			throw new NotAuthoriedException();
		}
	}

	@Override
	public int getBno(int rno) throws Exception {
		try {
			return session.selectOne(namespace+".getBno", rno);	
		} catch (NullPointerException e) {
			throw new NotExistException();
		}
		
	}

	@Override
	public List<UserReplyVO> pageList(ReplyVO reply) throws Exception {
		//Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("page", reply.getPage());
//		paramMap.put("perPageNum", reply.getPerPageNum());
		return session.selectList(namespace + ".pageList", reply);
	}
}
