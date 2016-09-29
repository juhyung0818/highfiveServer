package org.highfive.service;

import java.util.List;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;

public interface FavoritesService {
	public void regist(FavoritesVO favorite);
	public void delete(int fno);
	public List<UserBoardVO> favoritesList(String uid);
	public List<UserBoardVO> myBoardList(String uid);
	public List<UserBoardVO> myReplyList(String uid);
}
