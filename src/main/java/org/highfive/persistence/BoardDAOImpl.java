package org.highfive.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.BoardVO;
import org.highfive.domain.SearchKeyword;
import org.highfive.domain.UserBoardVO;
import org.highfive.exception.NotAuthoriedException;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	private String namespace = "org.highfive.mapper.BoardMapper";
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		session.insert(namespace+".regist", vo);
	}

	@Override
	public BoardVO read(BoardVO board) throws Exception {
		return session.selectOne(namespace+".read", board.getBno());
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		session.update(namespace+".modify", vo);
	}

	@Override
	public void delete(BoardVO board) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bno", board.getBno());
		paramMap.put("writer", board.getWriter());
		try {
			//check if it occur null point exception 
			session.selectOne(namespace+".getBno", paramMap).equals("");
			session.delete(namespace+".delete", paramMap);
		} catch (NullPointerException e) {
			throw new NotAuthoriedException();
		}
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
	public void updateViewCnt(BoardVO board) throws Exception {
		session.update(namespace+".updateViewCnt", board.getBno());
	}

	@Override
	public List<UserBoardVO> searchList(SearchKeyword keyword) throws Exception {
		return session.selectList(namespace+".searchList", keyword);
	}

	@Override
	public List<UserBoardVO> pageList(BoardVO board) throws Exception {
		return session.selectList(namespace + ".pageList", board);
	}

	
}
