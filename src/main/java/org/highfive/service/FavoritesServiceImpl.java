package org.highfive.service;

import java.util.List;
import javax.inject.Inject;
import org.highfive.domain.FavoritesVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.domain.UserVO;
import org.highfive.exception.NotExistException;
import org.highfive.persistence.FavoritesDAO;
import org.springframework.stereotype.Service;

@Service
public class FavoritesServiceImpl implements FavoritesService{

	@Inject
	private FavoritesDAO fdao;
	
	@Override
	public void isLike(FavoritesVO favorite) throws Exception {
		FavoritesVO temp = fdao.isLike(favorite);
		if(temp != null){
			fdao.delete(favorite);
		} else {
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
	public void delete(FavoritesVO favorite) throws Exception{
		fdao.delete(favorite);
	}

	@Override
	public List<UserBoardVO> favoritesList(UserVO user)throws Exception{
		List<UserBoardVO> list= fdao.myFavoritesList(user);
		if(list.size() !=0)
		{
			return list;
		}
		throw new NotExistException();
	}
	
	@Override
	public List<UserBoardVO> myBoardList(UserVO user) throws Exception{
		List<UserBoardVO> list= fdao.myBoardList(user);
		if(list.size() !=0)
		{
			return list;
		}
		throw new NotExistException();
	}

	@Override
	public List<UserBoardVO> myReplyList(UserVO user) throws Exception{
		List<UserBoardVO> list= fdao.myReplyList(user);
		if(list.size() !=0)
		{
			return list;
		}
		throw new NotExistException();
	}

	@Override
	public boolean checkLike(FavoritesVO favorite) throws Exception {
		FavoritesVO temp = fdao.isLike(favorite);
		if(temp != null){
			return true;
		} else {
			return false;
		}
	}
}
