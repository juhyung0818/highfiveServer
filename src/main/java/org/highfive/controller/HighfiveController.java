package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.ResultVO;
//<<<<<<< HEAD:src/main/java/org/highfive/controller/HighfiveController.java
//import org.highfive.domain.HighfiveVO;
//import org.highfive.service.highfiveService;
//=======
import org.highfive.domain.UserVO;
//import org.highfive.service.HighfiveService;
import org.highfive.service.highfiveService;
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5:src/main/java/org/highfive/controller/highfiveController.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/highfive/*")
public class HighfiveController {
	private static final Logger logger=LoggerFactory.getLogger(HighfiveController.class);
	
	@Inject
	//private HighfiveService hService;
	private highfiveService hService;
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
//<<<<<<< HEAD:src/main/java/org/highfive/controller/HighfiveController.java
//	public ResultVO registPOST(@RequestBody HighfiveVO high){
//		logger.info("regist post...........");
//		logger.info(high.toString());
//		
//		hservice.regist(high);
//		
//
//=======
	public ResultVO registPOST(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("highfive/regist.....");
		hService.regist(hf);
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5:src/main/java/org/highfive/controller/highfiveController.java
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
//<<<<<<< HEAD:src/main/java/org/highfive/controller/HighfiveController.java
//	public ResultVO deletePOST(@RequestBody HighfiveVO high){
//		logger.info("delete post...........");
//				
//		hservice.delete(high.getHno());
//				
//=======
	public ResultVO deletePOST(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("highfive/delete......");
		hService.delete(hf);
//>>>>>>> 90cbf3d0ecefb3c07518dc7a94aad18e4c60bbb5:src/main/java/org/highfive/controller/highfiveController.java
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/highfiveList", method=RequestMethod.POST)
	public List<UserVO> highfiveList(@RequestBody UserVO user) throws Exception{
		List<UserVO> users = new ArrayList<UserVO>();
		logger.info("highfive/accept......");
		users = hService.highfiveList(user.getUid());
		return users;
	}
	
	@ResponseBody
	@RequestMapping(value="/sendList", method=RequestMethod.POST)
	public List<UserVO> sendList(@RequestBody UserVO user) throws Exception{
		List<UserVO> users = new ArrayList<UserVO>();
		logger.info("highfive/accept......");
		users = hService.sendList(user.getUid());
		return users;
	}
	
	@ResponseBody
	@RequestMapping(value="/receiveList", method=RequestMethod.POST)
	public List<UserVO> receiveList(@RequestBody UserVO user) throws Exception{
		List<UserVO> users = new ArrayList<UserVO>();
		logger.info("highfive/accept......");
		users = hService.receiveList(user.getUid());
		return users;
	}
	
	@ResponseBody
	@RequestMapping(value="/accept", method=RequestMethod.POST)
	public ResultVO accept(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("highfive/accept......");
		hService.accept(hf);
		return new ResultVO();
	}
	
}
