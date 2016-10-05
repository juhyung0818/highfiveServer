package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;

public interface FavoritesDAO {
	public int isLike(FavoritesVO favorite) throws Exception;
	public void regist(FavoritesVO favorite) throws Exception;
	public void delete(int fno) throws Exception;
	public List<UserBoardVO> myFavoritesList(String uid) throws Exception;
	public List<UserBoardVO> myBoardList(String uid) throws Exception;
	public List<UserBoardVO> myReplyList(String uid) throws Exception;
}
