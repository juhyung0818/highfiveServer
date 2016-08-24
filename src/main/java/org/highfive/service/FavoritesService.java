package org.highfive.service;

import java.util.List;

import org.highfive.domain.FavoritesVO;

public interface FavoritesService {
	public void regist(FavoritesVO favorite);
	public FavoritesVO read(int fno);
	public void delete(int fno);
	public List<FavoritesVO> listAll();
}
