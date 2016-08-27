package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.HighfiveVO;
import org.highfive.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class highfiveDAOImpl implements HighfiveDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace="org.highfive.mapper.HighfiveMapper";

	@Override
	public void regist(HighfiveVO hf) {
		session.insert(namespace+".regist", hf);
	}

	@Override
	public void delete(HighfiveVO hf) {
		session.delete(namespace+".delete", hf);
	}

	@Override
	public int getFlag(HighfiveVO hf) throws Exception {
		return session.selectOne(namespace+".getFlag", hf);
	}

	@Override
	public void accept(HighfiveVO hf) throws Exception {
		session.update(namespace+".accept", hf);
	}

	@Override
	public List<UserVO> highfiveList(String uid) throws Exception {
		return session.selectList(namespace+".highfiveList", uid);
	}

	@Override
	public List<UserVO> sendList(String uid) throws Exception {
		return session.selectList(namespace+".sendList", uid);
	}

	@Override
	public List<UserVO> receiveList(String uid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".receiveList", uid);
	}
}
