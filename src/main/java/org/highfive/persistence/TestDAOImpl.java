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
	public void create(TestVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".create", vo);
	}
	
	
}
