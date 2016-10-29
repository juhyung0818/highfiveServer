package org.highfive.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.UserVO;
import org.highfive.exception.PrimaryKeyDuplicatedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	private String namespace = "org.highfive.mapper.UserMapper";

	@Override
	public void regist(UserVO user) {
		try{
			session.insert(namespace + ".regist", user);
		}catch(DuplicateKeyException e){
			throw new PrimaryKeyDuplicatedException();
		}
	}

	@Override
	public UserVO read(String uid, int flag) throws Exception {
		if (flag == 0) {
			return session.selectOne(namespace + ".hiRead", uid);
		} else {
			return session.selectOne(namespace + ".nomalRead", uid);
		}
	}
	
	@Override
	public void modify(UserVO user) throws Exception {
		session.update(namespace + ".modify", user);
	}

	@Override
	public void delete(String uid) throws Exception {
		session.delete(namespace + ".delete", uid);
	}

	@Override
	public String checkUser(UserVO user) throws Exception {
		return session.selectOne(namespace + ".checkUser", user.getUid());
	}
	
	@Override
	public String checkUname(UserVO user) throws Exception {
		return session.selectOne(namespace + ".checkUname", user.getUname());
	}

}
