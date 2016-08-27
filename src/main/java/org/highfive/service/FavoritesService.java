package org.highfive.service;

import java.util.List;

import org.highfive.domain.FavoritesVO;
//<<<<<<< HEAD
//import org.highfive.domain.HighfiveVO;
//=======
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5

public interface FavoritesService {
	public void regist(FavoritesVO favorite);
	public FavoritesVO read(int fno);
	public void delete(int fno);
	public List<FavoritesVO> listAll();
}
