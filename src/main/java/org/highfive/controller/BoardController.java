package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	@RequestMapping(value="/regist")
	public String registPOST() throws Exception{
		BoardVO vo = new BoardVO();
		logger.info("register post.......");
		service.regist(vo);
		return "/success";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public @ResponseBody BoardVO read() throws Exception{
		BoardVO vo = new BoardVO();
		vo = service.read(2);
		logger.info(vo.toString());
//		model.addAttribute(service.read(bno));
		return vo;
	}
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public @ResponseBody List<BoardVO> listAll() throws Exception{
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = service.listAll();
		logger.info("list.....");
//		model.addAttribute(service.read(bno));
		return list;
	}

	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public void removeGET() throws Exception{
		logger.info("remove GET.......");
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removePOST(int bno) throws Exception{
		logger.info(service.read(bno).toString());
		service.remove(bno);
		return "/success";
	}
}
