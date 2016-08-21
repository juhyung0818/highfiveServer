package org.highfive.persistence;

import java.util.List;

import org.highfive.domain.BoardVO;
import org.highfive.domain.UserBoardVO;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<UserBoardVO> listAll(int flag) throws Exception;
}
