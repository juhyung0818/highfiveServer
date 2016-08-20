package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.ResultVO;
import org.highfive.domain.UserVO;
import org.highfive.exception.ExceptionCode;
import org.highfive.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Inject
	private UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody UserVO user) throws Exception{
		logger.info("register post.......");
		
		userService.regist(user);
		return new ResultVO();
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public @ResponseBody UserVO read() throws Exception{
		UserVO user = new UserVO();
		user = userService.read("user");
		logger.info(user.toString());
		return user;
	}

	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public void removeGET() throws Exception{
		logger.info("remove GET.......");
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removePOST(String uid) throws Exception{
		logger.info(userService.read(uid).toString());
		userService.remove(uid);
		return "/success";
	}
	
	
}
