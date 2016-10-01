package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.persistence.FavoritesDAO;
import org.springframework.stereotype.Service;

@Service
public class FavoritesServiceImpl implements FavoritesService{

	@Inject
	private FavoritesDAO fdao;
	
	//좋아하는 게시글로 등록
	@Override
	public void regist(FavoritesVO favorite){
		fdao.regist(favorite);
	}
	
	//좋아하는 게시글 목록에서 삭제
	@Override
	public void delete(int fno) {
		fdao.delete(fno);
	}

	@Override
	public List<UserBoardVO> favoritesList(String uid) {
		return fdao.myFavoritesList(uid);
	}

	@Override
	public List<UserBoardVO> myBoardList(String uid) {
		return fdao.myBoardList(uid);
	}

	@Override
	public List<UserBoardVO> myReplyList(String uid) {
		return fdao.myReplyList(uid);
	}
}
