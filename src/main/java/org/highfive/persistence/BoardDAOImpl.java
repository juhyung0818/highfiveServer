package org.highfive.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.BoardVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.exception.UserIdDuplicatedException;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	private String namespace = "org.highfive.mapper.BoardMapper";
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		try{
			session.insert(namespace+".regist", vo);
		} catch(PersistenceException e){
			if(e.getCause() instanceof MySQLIntegrityConstraintViolationException){
				throw new UserIdDuplicatedException();				
			}
			throw new RuntimeException();
		}
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		session.update(namespace+".modify", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<UserBoardVO> listAll(int flag) throws Exception {
		return session.selectList(namespace+".listAll", flag);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		session.update(namespace+".updateReplyCnt", paramMap);
	}

	@Override
	public void updateViewCnt(int bno) throws Exception {
		session.update(namespace+".updateViewCnt", bno);
	}

	@Override
	public List<UserBoardVO> searchList(String keyword) throws Exception {
		return session.selectList(namespace+".searchList", keyword);
	}

	
}
