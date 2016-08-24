package org.highfive.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void regist(HighfiveVO hf) {
		session.insert(namespace+".regist", hf);
	}

	@Override
	public void delete(String receiver, String sender) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("receiver", receiver);
		paramMap.put("sender", sender);
		session.delete(namespace+".delete", paramMap);
	}

	@Override
	public int getFlag(HighfiveVO hf) throws Exception {
		Map<String, Object> paramMap= new HashMap<String, Object>();
		paramMap.put("receiver", hf.getReceiver());
		paramMap.put("sender", hf.getSenddate());
		return session.selectOne(namespace+".getFlag", paramMap);
	}

	@Override
	public void accept(HighfiveVO hf) throws Exception {
		Map<String, Object> paramMap= new HashMap<String, Object>();
		paramMap.put("receiver", hf.getReceiver());
		paramMap.put("sender", hf.getSenddate());
		session.update(namespace+".accept", paramMap);
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
