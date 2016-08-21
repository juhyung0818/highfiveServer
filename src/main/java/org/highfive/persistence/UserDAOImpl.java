package org.highfive.persistence;

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
	public UserVO read(String uid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".read", uid);
	}

	@Override
	public void modify(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".modify");
	}

	@Override
	public void delete(String user) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete");
	}

}
