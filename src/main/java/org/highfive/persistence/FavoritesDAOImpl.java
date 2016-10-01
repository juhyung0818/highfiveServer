package org.highfive.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class FavoritesDAOImpl implements FavoritesDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace="org.highfive.mapper.FavoritesMapper";
	
	//좋아하는 게시글목록에 등록
	@Override
	public void regist(FavoritesVO favorite) {
		session.insert(namespace + ".regist",favorite);
	}
	
	//좋아하는 게시글목록에서 삭제
	@Override
	public void delete(int fno) {
		session.delete(namespace + ".delete",fno);
	}

	//좋아하는 게시글 목록
	@Override
	public List<UserBoardVO> myFavoritesList(String uid) {
		return session.selectList(namespace + ".favoritesList", uid);
	}

	//내가 작성한 게시글 목록
	@Override
	public List<UserBoardVO> myBoardList(String uid) {
		return session.selectList(namespace + ".myBoardList", uid);
	}

	//내가 댓글을 작성한 게시글 목록
	@Override
	public List<UserBoardVO> myReplyList(String uid) {
		return session.selectList(namespace + ".myReplyList", uid);
	}
}