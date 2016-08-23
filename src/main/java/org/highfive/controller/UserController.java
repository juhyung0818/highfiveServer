package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.ResultVO;
import org.highfive.domain.UserVO;
import org.highfive.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Inject
	private UserService userService;
//	@Inject
//	private HighfiveService hfService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody UserVO user) throws Exception{
		logger.info("register post.......");
		userService.regist(user);
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public UserVO read(@RequestBody UserVO user) throws Exception{
		//TODO highfive check method 
		//return integer
		// user = userService.read(user.getUid(), (int)flag);
		user = userService.read(user.getUid());
		logger.info(user.toString());
		return user;
	}

	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO delete(@RequestBody UserVO user) throws Exception{
		logger.info("delete.....");
		userService.delete(user.getUid());
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/testRead", method=RequestMethod.POST)
	public UserVO testRead(@RequestBody UserVO user) throws Exception{
		user = userService.testRead(user.getUid(), 1);
		logger.info(user.toString());
		return user;
	}
}
