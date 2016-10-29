package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.domain.FavoritesVO;
import org.highfive.domain.ResultVO;
import org.highfive.domain.SearchKeyword;
import org.highfive.domain.UserBoardVO;
import org.highfive.service.BoardService;
import org.highfive.service.FavoritesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService boardService;
	@Inject
	private FavoritesService fService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody BoardVO board) throws Exception{
		logger.info("register post.......");
		boardService.regist(board);
		return new ResultVO();
	}
	
	//host/board/read?bno=8
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public ResultVO<BoardVO> read(@RequestBody BoardVO board) throws Exception{
		logger.info("board read............ ");
		FavoritesVO favorite = new FavoritesVO();
		favorite.setBno(board.getBno());
		favorite.setUid(board.getWriter());
		board = boardService.read(board);
		System.out.println(favorite.toString());
		board.setLike(fService.checkLike(favorite));
		return new ResultVO<>(board);
	}
	
	//host/board/listAll?flag=#{flag} 외국인=0, 내국인=1
	@ResponseBody
	@RequestMapping(value="/listAll", method=RequestMethod.POST)
	public ResultVO<List<UserBoardVO>> listAll(@RequestBody BoardVO board) throws Exception{
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = boardService.listAll(board.getFlag());
		logger.info("board listAll.....");
		return new ResultVO<>(list);
	}
	
	//host/board/searchList?keyword=new
	@ResponseBody
	@RequestMapping(value="/searchList", method=RequestMethod.POST)
	public ResultVO<List<UserBoardVO>> searchList(@RequestBody SearchKeyword keyword) throws Exception{
		logger.info("board searchList keyword : " + keyword.getKeyword());
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = boardService.searchList(keyword);
		return new ResultVO<>(list);
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ResultVO modify(@RequestBody BoardVO board) throws Exception{
		logger.info(board.getBno()+" update......");
		boardService.modify(board);
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO delete(@RequestBody BoardVO board) throws Exception{
		logger.info(board.getBno() + "board delete....");
		boardService.delete(board);
		return new ResultVO();
	}
	
	//host/board/pageList
	@ResponseBody
	@RequestMapping(value="/pageList", method=RequestMethod.POST)
	public ResultVO<List<UserBoardVO>> pageList(@RequestBody BoardVO board) throws Exception{
		logger.info("board pageList.....");
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = boardService.pageList(board);
		
		return new ResultVO<>(list);
	}
}
