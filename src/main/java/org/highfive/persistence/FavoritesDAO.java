package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.FavoritesVO;

public interface FavoritesDAO {
	public void regist(FavoritesVO favorite);
	
	public void delete(int fno);
	
	public FavoritesVO read(int fno);
	
	public List<FavoritesVO> listAll();
}
