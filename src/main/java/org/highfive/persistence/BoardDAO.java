package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.BoardVO;
import org.highfive.domain.PageVO;
import org.highfive.domain.SearchKeyword;
import org.highfive.domain.UserBoardVO;

public interface BoardDAO {

	public void regist(BoardVO vo) throws Exception;
	public BoardVO read(BoardVO board) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public void delete(BoardVO board) throws Exception;
	public List<UserBoardVO> listAll(int flag) throws Exception;
	public void updateReplyCnt(int bno, int amount) throws Exception;
	public void updateViewCnt(BoardVO board) throws Exception;
	public List<UserBoardVO> searchList(SearchKeyword keyword) throws Exception;
	public List<UserBoardVO> pageList(PageVO page) throws Exception;
	
}
