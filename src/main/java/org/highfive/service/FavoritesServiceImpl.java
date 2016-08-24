package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.FavoritesVO;
import org.highfive.persistence.FavoritesDAO;
import org.springframework.stereotype.Service;

@Service
public class FavoritesServiceImpl implements FavoritesService{

	@Inject
	private FavoritesDAO fdao;
	
	@Override
	public void regist(FavoritesVO favorite){
		fdao.regist(favorite);
		
	}

	@Override
	public FavoritesVO read(int fno) {
		return fdao.read(fno);
	}

	@Override
	public void delete(int fno) {
		fdao.delete(fno);
		
	}

	@Override
	public List<FavoritesVO> listAll() {
		return fdao.listAll();
	}

}
