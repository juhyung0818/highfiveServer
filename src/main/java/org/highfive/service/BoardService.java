package org.highfive.service;

import java.util.List;

import org.highfive.domain.BoardVO;
import org.highfive.domain.UserBoardVO;

public interface BoardService {
	public void regist(BoardVO board) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void modify(BoardVO board) throws Exception;
	public void delete(int bno) throws Exception;
	public List<UserBoardVO> listAll(int flag) throws Exception;
	public List<UserBoardVO> searchList(String keyword) throws Exception;
}
