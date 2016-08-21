package org.highfive.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.TestVO;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="org.highfive.mapper.TestMapper";

	@Override
	public void insertTest(TestVO vo) {
		sqlSession.insert(namespace+".insertTest", vo);
	}

	@Override
	public TestVO read(int bno) {
		return sqlSession.selectOne(namespace+".read", bno);
	}
	
	
	
}
