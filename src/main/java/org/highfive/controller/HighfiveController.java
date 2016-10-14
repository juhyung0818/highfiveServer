package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.ResultVO;
import org.highfive.domain.UserVO;
import org.highfive.service.HighfiveService;
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

	private static final Logger logger = LoggerFactory.getLogger(HighfiveController.class);

	@Inject
	private HighfiveService hService;

	// register board
	// flag=0 :  
	@ResponseBody
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ResultVO registPOST(@RequestBody HighfiveVO hf) throws Exception {
		logger.info("highfive/regist.....");
		hService.regist(hf);
		return new ResultVO();
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResultVO deletePOST(@RequestBody HighfiveVO hf) throws Exception {
		logger.info("highfive/delete......");
		hService.delete(hf);
		return new ResultVO();
	}

	@ResponseBody
	@RequestMapping(value = "/highfiveList", method = RequestMethod.POST)
	public ResultVO<List<UserVO>> highfiveList(@RequestBody HighfiveVO hf) throws Exception {
		List<UserVO> users = new ArrayList<UserVO>();
		logger.info("highfive/list......");
		users = hService.highfiveList(hf);
		return new ResultVO<>(users);
	}

	@ResponseBody
	@RequestMapping(value = "/sendList", method = RequestMethod.POST)
	public ResultVO<List<UserVO>> sendList(@RequestBody HighfiveVO hf) throws Exception {
		List<UserVO> users = new ArrayList<UserVO>();
		logger.info("highfive/sendList......");
		users = hService.sendList(hf);
		return new ResultVO<>(users);
	}

	@ResponseBody
	@RequestMapping(value = "/receiveList", method = RequestMethod.POST)
	public ResultVO<List<UserVO>> receiveList(@RequestBody HighfiveVO hf) throws Exception {
		List<UserVO> users = new ArrayList<UserVO>();
		logger.info("highfive/receiverlist......");
		users = hService.receiveList(hf);
		return new ResultVO<>(users);
	}

	@ResponseBody
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public ResultVO accept(@RequestBody HighfiveVO hf) throws Exception {
		logger.info("highfive/accept......");
		hService.accept(hf);
		return new ResultVO();
	}

	@ResponseBody
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ResultVO check(@RequestBody HighfiveVO hf) throws Exception {
		logger.info("highfive/check......");
		return new ResultVO<>(hService.highfiveCheck(hf));
	}
}
