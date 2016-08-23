package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.domain.ResultVO;
import org.highfive.domain.SearchKeyword;
import org.highfive.domain.UserBoardVO;
import org.highfive.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody BoardVO board) throws Exception{
		logger.info("register post.......");
		service.regist(board);
		return new ResultVO();
	}
	
	//host/board/read?bno=8
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public BoardVO read(@RequestBody BoardVO board) throws Exception{
		board = service.read(board.getBno());
		logger.info(board.toString());
		return board;
	}
	
	//host/board/listAll?flag=#{flag} 외국인=0, 내국인=1
	@ResponseBody
	@RequestMapping(value="/listAll", method=RequestMethod.POST)
	public List<UserBoardVO> listAll(@RequestBody BoardVO board) throws Exception{
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = service.listAll(board.getFlag());
		logger.info("board listAll.....");
		return list;
	}
	
	//host/board/searchList?keyword=new
	@ResponseBody
	@RequestMapping(value="/searchList", method=RequestMethod.POST)
	public List<UserBoardVO> searchList(@RequestBody SearchKeyword keyword) throws Exception{
		logger.info("board searchList keyword : " + keyword.getKeyword());
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = service.searchList(keyword.getKeyword());
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO delete(@RequestBody BoardVO board) throws Exception{
		logger.info(service.read(board.getBno()).toString());
		service.delete(board.getBno());
		return new ResultVO();
	}
	
	
}
