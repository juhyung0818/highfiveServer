package org.highfive.service;

import java.util.List;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;

public interface FavoritesService {
	public void  isLike(FavoritesVO favorite) throws Exception;
	public void regist(FavoritesVO favorite) throws Exception;
	public void delete(int fno) throws Exception;
	public List<UserBoardVO> favoritesList(String uid) throws Exception;
	public List<UserBoardVO> myBoardList(String uid) throws Exception;
	public List<UserBoardVO> myReplyList(String uid) throws Exception;
}
