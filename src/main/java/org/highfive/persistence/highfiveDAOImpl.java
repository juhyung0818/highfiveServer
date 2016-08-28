package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.HighfiveVO;
import org.highfive.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class highfiveDAOImpl implements highfiveDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace="org.highfive.mapper.HighfiveMapper";

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

	public void accept(HighfiveVO hf) {
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
		return session.selectList(namespace+".receiveList", uid);
	}
}
