package org.highfive.service;

import java.util.List;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.domain.UserVO;

public interface FavoritesService {
	public void regist(FavoritesVO favorite) throws Exception;
	public void delete(FavoritesVO favorite) throws Exception;
	public List<UserBoardVO> favoritesList(UserVO user) throws Exception;
	public List<UserBoardVO> myBoardList(UserVO user) throws Exception;
	public List<UserBoardVO> myReplyList(UserVO user) throws Exception;
	public void isLike(FavoritesVO favorite) throws Exception;
	public boolean checkLike(FavoritesVO favorite) throws Exception;
}
