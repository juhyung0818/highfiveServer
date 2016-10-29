package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.domain.UserVO;

public interface FavoritesDAO {
	public void regist(FavoritesVO favorite) throws Exception;
	public void delete(FavoritesVO favorite) throws Exception;
	public List<UserBoardVO> myFavoritesList(UserVO user) throws Exception;
	public List<UserBoardVO> myBoardList(UserVO user) throws Exception;
	public List<UserBoardVO> myReplyList(UserVO user) throws Exception;
	public FavoritesVO isLike(FavoritesVO favorite) throws Exception;
}
