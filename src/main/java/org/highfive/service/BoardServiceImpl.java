package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.domain.PageVO;
import org.highfive.domain.SearchKeyword;
import org.highfive.domain.UserBoardVO;
import org.highfive.persistence.BoardDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.regist(board);
	}

	@Transactional
	@Override
	public BoardVO read(int bno) throws Exception {
		dao.updateViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.modify(board);
	}

	@Override
	public void delete(BoardVO board) throws Exception {
		dao.delete(board);
	}

	@Override
	public List<UserBoardVO> listAll(int flag) throws Exception {
		return dao.listAll(flag);
	}

	@Override
	public List<UserBoardVO> searchList(SearchKeyword keyword) throws Exception {
		return dao.searchList(keyword);
	}

	@Override
	public List<UserBoardVO> pageList(PageVO page) throws Exception {
		return dao.pageList(page);
	}
	
}
