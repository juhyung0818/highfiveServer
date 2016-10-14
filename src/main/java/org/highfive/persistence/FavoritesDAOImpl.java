package org.highfive.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.domain.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public class FavoritesDAOImpl implements FavoritesDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace="org.highfive.mapper.FavoritesMapper";
	
	@Override
	public FavoritesVO isLike(FavoritesVO favorites) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", favorites.getUid());
		paramMap.put("bno", favorites.getBno());
		return session.selectOne(namespace + ".isLike", paramMap);
	}
	
	//좋아하는 게시글목록에 등록
	@Override
	public void regist(FavoritesVO favorite) throws Exception{
		session.insert(namespace + ".regist",favorite);
	}
	
	//좋아하는 게시글목록에서 삭제
	@Override
	public void delete(FavoritesVO favorites) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", favorites.getUid());
		paramMap.put("bno", favorites.getBno());
		session.delete(namespace + ".delete", paramMap);
	}

	//좋아하는 게시글 목록
	@Override
	public List<UserBoardVO> myFavoritesList(UserVO user) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", user.getUid());
		paramMap.put("page", user.getPage());
		paramMap.put("perPageNum", user.getPerPageNum());
		return session.selectList(namespace + ".favoritesList", paramMap);
	}

	//내가 작성한 게시글 목록
	@Override
	public List<UserBoardVO> myBoardList(UserVO user) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", user.getUid());
		paramMap.put("page", user.getPage());
		paramMap.put("perPageNum", user.getPerPageNum());
		return session.selectList(namespace + ".myBoardList", paramMap);
	}

	//내가 댓글을 작성한 게시글 목록
	@Override
	public List<UserBoardVO> myReplyList(UserVO user) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", user.getUid());
		paramMap.put("page", user.getPage());
		paramMap.put("perPageNum", user.getPerPageNum());
		return session.selectList(namespace + ".myReplyList", paramMap);
	}
}