package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.domain.ResultVO;
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

//	@RequestMapping(value="/regist", method=RequestMethod.GET)
//	public void registGET() throws Exception{
//		logger.info("regist get.....");
//	}
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist() throws Exception{
		BoardVO vo = new BoardVO();
		logger.info("register post.......");
		service.regist(vo);
		return "/success";
	}
	
	//host/read?bno=8
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public @ResponseBody BoardVO read(@RequestParam int bno) throws Exception{
		BoardVO vo = new BoardVO();
		vo = service.read(bno);
		logger.info(vo.toString());
		return vo;
	}
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public @ResponseBody List<UserBoardVO> listAll() throws Exception{
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		byte flag = 0; // 외국인=0, 내국인=1
		list = service.listAll(flag);
		logger.info("list.....");
//		model.addAttribute(service.read(bno));
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResultVO remove(@RequestParam int bno) throws Exception{
		logger.info(service.read(bno).toString());
		service.remove(bno);
		return new ResultVO();
	}
}
