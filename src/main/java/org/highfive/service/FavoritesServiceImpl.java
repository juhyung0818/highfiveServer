package org.highfive.service;

import java.util.FormatFlagsConversionMismatchException;
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
	
	@Override
	public void isLike(FavoritesVO favorite) throws Exception {
		int num = fdao.isLike(favorite);
		String check = null;
		try{
			check.valueOf(num);
			fdao.delete(num);
		} catch(FormatFlagsConversionMismatchException e){
			fdao.regist(favorite);
		}
	}
	
	//좋아하는 게시글로 등록
	@Override
	public void regist(FavoritesVO favorite) throws Exception{
		fdao.regist(favorite);
	}
	
	//좋아하는 게시글 목록에서 삭제
	@Override
	public void delete(int fno) throws Exception{
		fdao.delete(fno);
	}

	@Override
	public List<UserBoardVO> favoritesList(String uid) throws Exception{
		return fdao.myFavoritesList(uid);
	}

	@Override
	public List<UserBoardVO> myBoardList(String uid) throws Exception{
		return fdao.myBoardList(uid);
	}

	@Override
	public List<UserBoardVO> myReplyList(String uid) throws Exception{
		return fdao.myReplyList(uid);
	}
}
