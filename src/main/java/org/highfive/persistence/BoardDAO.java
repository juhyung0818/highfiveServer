package org.highfive.persistence;

import org.highfive.domain.BoardVO;

public interface BoardDAO {

	public void create(BoardVO vo) throws Exception; // 게시글 생성
	public BoardVO read(Integer bno) throws Exception; //상세읽기
	public void update(BoardVO vo) throws Exception; //게시글 수정
	public void delete(Integer bno) throws Exception; //게시글 삭제
//	public List<BoardVO> listAll() throws Exception; //게시글 전체 조회
	
}