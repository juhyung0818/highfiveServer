package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.highfiveVO;
import org.springframework.stereotype.Repository;

@Repository
public class highfiveDAOImpl implements highfiveDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace="org.highfive.mapper.highfiveMapper";

	@Override
	public void regist(highfiveVO hvo) {
		// TODO Auto-generated method stub
		session.insert(namespace+".regist", hvo);
	}

	@Override
	public highfiveVO read(Integer hno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read",hno);
	}

	@Override
	public void delete(Integer hno) {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",hno);
	}

	@Override
	public List<highfiveVO> listAll() {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"listAll");
	}
}
