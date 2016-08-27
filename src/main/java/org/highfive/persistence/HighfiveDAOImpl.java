package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.HighfiveVO;
import org.springframework.stereotype.Repository;

@Repository
public class HighfiveDAOImpl implements HighfiveDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace="org.highfive.mapper.highfiveMapper";

	@Override
	public void regist(HighfiveVO hvo) {
		session.insert(namespace+".regist", hvo);
	}

	@Override
	public HighfiveVO read(Integer hno) {
		return session.selectOne(namespace+".read",hno);
	}

	@Override
	public void delete(Integer hno) {
		session.delete(namespace+".delete",hno);
	}

	@Override
	public List<HighfiveVO> listAll() {
		return session.selectList(namespace+"listAll");
	}
}
