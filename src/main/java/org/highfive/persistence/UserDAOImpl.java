package org.highfive.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.UserVO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession session;
	private String namespace = "org.highfive.mapper.UserMapper";

	@Override
	public void register(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".register", user);
	}

	@Override
	public UserVO read(String uid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", uid);
	}

	@Override
	public void modify(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".modify");
	}

	@Override
	public void delete(String user) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete");
	}
	
}
