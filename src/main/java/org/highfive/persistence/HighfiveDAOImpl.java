package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.HighfiveVO;

import org.highfive.domain.UserVO;
import org.highfive.exception.NotExistException;
import org.springframework.stereotype.Repository;

@Repository
public class HighfiveDAOImpl implements HighfiveDAO{
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

	public void accept(HighfiveVO hf) {
		session.update(namespace+".accept", hf);
	}

	@Override
	public List<UserVO> highfiveList(HighfiveVO hf) throws Exception {
		return session.selectList(namespace+".highfiveList", hf);
	}

	@Override
	public List<UserVO> sendList(HighfiveVO hf) throws Exception {
		return session.selectList(namespace+".sendList", hf);
	}

	@Override
	public List<UserVO> receiveList(HighfiveVO hf) throws Exception {
		return session.selectList(namespace+".receiveList", hf);
	}

	@Override
	public int highfiveCheck(HighfiveVO hf) throws Exception {
		try{
			return session.selectOne(namespace + ".highfiveCheck", hf);
		}catch(NullPointerException e){
			return 3;
		}
	}
}
