package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.ResultVO;
import org.highfive.domain.UserVO;
import org.highfive.service.HighfiveService;
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
	@Inject
	private HighfiveService hfService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO regist(@RequestBody UserVO user) throws Exception{
		logger.info("register post.......");
		userService.regist(user);
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/read", method=RequestMethod.POST)
	public ResultVO<UserVO> read(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("user/read ......");
		int flag;	
		try{
			flag = hfService.highfiveCheck(hf);
		} catch(NullPointerException e){
			flag = 1;
		}
		UserVO user = new UserVO();
		user = userService.read(hf.getReceiver(), flag);
		logger.info(user.toString());
		return new ResultVO<>(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public ResultVO<UserVO> modify(@RequestBody UserVO user) throws Exception{
		logger.info(user.getUid() + " - user modify.......");
		userService.modify(user);
		return new ResultVO();
	}

	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO delete(@RequestBody UserVO user) throws Exception{
		logger.info("delete.....");
		userService.delete(user.getUid());
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/checkUser", method=RequestMethod.POST)
	public ResultVO<Boolean> checkUser(@RequestBody UserVO user) throws Exception{
		logger.info(user.getUid() + "checkUser.....");
		return new ResultVO<>(userService.checkUser(user));
	}
	
	@ResponseBody
	@RequestMapping(value="/checkUname", method=RequestMethod.POST)
	public ResultVO<Boolean> checkUname(@RequestBody UserVO user) throws Exception{
		logger.info(user.getUname() + "checkUname.....");
		return new ResultVO<>(userService.checkUname(user));
	}
	
}
