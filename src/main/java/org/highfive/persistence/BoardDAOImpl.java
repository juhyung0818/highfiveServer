package org.highfive.persistence;

import java.util.List;

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
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		try{
			session.insert(namespace+".create", vo);
		} catch(PersistenceException e){
			if(e.getCause() instanceof MySQLIntegrityConstraintViolationException){
				throw new UserIdDuplicatedException();				
			}
			throw new RuntimeException();
		}
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".modify", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<UserBoardVO> listAll(int flag) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listAll");
	}

	
}
