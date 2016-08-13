package org.highfive.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	private static String namespace = "org.seoul.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete", bno);
	}

//	@Override // 전체조회 일단 보류 (두가지 VO가 합쳐져야함)
//	public List<BoardVO> listAll() throws Exception {
//		// TODO Auto-generated method stub
//		return session.selectList(namespace+".listAll");
//	}

}
