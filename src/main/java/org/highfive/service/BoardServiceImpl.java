package org.highfive.service;

import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.persistence.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("jh");
		board.setStartdate("2016-08-10");
		board.setEnddate("2016-08-17");
		board.setLanguage("jp");
		board.setFlag(0);
		dao.create(board);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		dao.modify(board);
	}

	@Override
	public void remove(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}
	
}
