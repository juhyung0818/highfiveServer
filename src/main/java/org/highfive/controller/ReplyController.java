package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.ReplyVO;
import org.highfive.domain.ResultVO;
import org.highfive.domain.UserReplyVO;
import org.highfive.service.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody ReplyVO reply) throws Exception{
		logger.info("regist post.......");
		replyService.regist(reply);
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public List<UserReplyVO> list(@RequestParam int bno) throws Exception{
		List<UserReplyVO> list = new ArrayList<UserReplyVO>();
		list = replyService.list(bno);
		return list;
	} //remake query 
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO delete(@RequestBody ReplyVO reply) throws Exception{
		logger.info("delete.....");
		replyService.delete(reply.getRno());
		return new ResultVO();
	}
}
