package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.domain.ResultVO;
import org.highfive.service.highfiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/highfive/*")
public class highfiveController {
	private static final Logger logger=LoggerFactory.getLogger(highfiveController.class);
	
	@Inject
	private highfiveService hService;
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO registPOST(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("highfive/regist.....");
		hService.regist(hf);
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO deletePOST(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("highfive/delete......");
		hService.delete(hf);
		return new ResultVO();
	}
	
	@ResponseBody
	@RequestMapping(value="/accept", method=RequestMethod.POST)
	public ResultVO accept(@RequestBody HighfiveVO hf) throws Exception{
		logger.info("highfive/accept......");
		hService.accept(hf);
		return new ResultVO();
	}
	
}
