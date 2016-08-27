package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.HighfiveVO;
//<<<<<<< HEAD:src/main/java/org/highfive/persistence/HighfiveDAOImpl.java
//=======
import org.highfive.domain.UserVO;
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5:src/main/java/org/highfive/persistence/highfiveDAOImpl.java
import org.springframework.stereotype.Repository;

@Repository
public class HighfiveDAOImpl implements HighfiveDAO{
	@Inject
	private SqlSession session;
	
	private static String namespace="org.highfive.mapper.HighfiveMapper";

//	@Override
//<<<<<<< HEAD:src/main/java/org/highfive/persistence/HighfiveDAOImpl.java
//	public void regist(HighfiveVO hvo) {
//		session.insert(namespace+".regist", hvo);
//	}

//	@Override
//	public HighfiveVO read(Integer hno) {
//		return session.selectOne(namespace+".read",hno);
//	}
//=======
	public void regist(HighfiveVO hf) {
		session.insert(namespace+".regist", hf);
	}

	@Override
	public void delete(HighfiveVO hf) {
		session.delete(namespace+".delete", hf);
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5:src/main/java/org/highfive/persistence/highfiveDAOImpl.java
	}

	@Override
	public int getFlag(HighfiveVO hf) throws Exception {
		return session.selectOne(namespace+".getFlag", hf);
	}

	@Override
//<<<<<<< HEAD:src/main/java/org/highfive/persistence/HighfiveDAOImpl.java
	public List<HighfiveVO> listAll() {
		return session.selectList(namespace+"listAll");
	}
//=======
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
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5:src/main/java/org/highfive/persistence/highfiveDAOImpl.java
	}
}
