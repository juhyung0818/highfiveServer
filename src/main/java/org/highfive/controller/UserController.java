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
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody UserVO user) throws Exception{
		logger.info("register post.......");
		userService.regist(user);
		return new ResultVO();
	}
	
	//host/user/read?uid=#{uid}
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public @ResponseBody UserVO read(@RequestParam String uid) throws Exception{
		UserVO user = new UserVO();
		user = userService.read(uid);
		logger.info(user.toString());
		return user;
	}

//	@ResponseBody
//	@RequestMapping(value="/remove", method=RequestMethod.GET)
//	public ResultVO remove() throws Exception{
//		logger.info("remove GET.......");
//		String user="user";
//		userService.read("\""+user+"\"");
//		return new ResultVO();
//	}
	
	@ResponseBody
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResultVO remove(@RequestParam String uid) throws Exception{
		logger.info("remove.....");
//		String[] uid=body.split("\"");
		String user="user";
//		System.out.println(uid[1]);
		userService.remove(user);
		return new ResultVO();
	}
	
	
}
