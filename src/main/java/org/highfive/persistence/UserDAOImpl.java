package org.highfive.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.UserVO;
import org.highfive.exception.InvalidTypeException;
import org.highfive.exception.UserIdDuplicatedException;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession session;
	private String namespace = "org.highfive.mapper.UserMapper";

	@Override
	public void regist(UserVO user) {
		try {
			session.insert(namespace + ".regist", user);
		} catch (PersistenceException e) {
			if (e.getCause() instanceof InvalidFormatException) {
				throw new InvalidTypeException();
			} else if (e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
				throw new UserIdDuplicatedException();
			}
		}
	}
	
	@Override
	public UserVO read(String uid, int flag) throws Exception {
		if(flag == 0){
			return session.selectOne(namespace+".hiRead", uid);
		}
		else{
			return session.selectOne(namespace+".nomalread", uid);
		}
	}
	
	@Override
	public void modify(UserVO user) throws Exception {
		session.update(namespace + ".modify");
	}

	@Override
	public void delete(String uid) throws Exception {
		session.delete(namespace + ".delete", uid);
	}



}
