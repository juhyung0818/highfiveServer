package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.FavoritesVO;
import org.springframework.stereotype.Repository;

@Repository
public class FavoritesDAOImpl implements FavoritesDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace="org.zerock.mapper.FavoritesMapper";
	
	@Override
	public void regist(FavoritesVO favorite) {
		session.insert(namespace+".regist",favorite);
	}
	
	@Override
	public void delete(int fno) {
		session.delete(namespace+".regist",fno);
		
	}

	@Override
	public FavoritesVO read(int fno) {
		return session.selectOne(namespace+".read", fno);
	}

	@Override
	public List<FavoritesVO> listAll() {
		return session.selectList(namespace+"listAll");
	}



}
