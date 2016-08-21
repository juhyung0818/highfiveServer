package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.ResultVO;
import org.highfive.domain.highfiveVO;
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
	private highfiveService hservice;
	
//	@RequestMapping(value="/register", method=RequestMethod.GET)
//	public void registerGET(highfiveVO hogh, Model hmodel){
//		logger.info("register get........");
//	}
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO registPOST(@RequestBody highfiveVO high){
		logger.info("regist post...........");
		logger.info(high.toString());
		
		hservice.regist(high);
		
//		hmodel.addAttribute("result", "success");
		
		return new ResultVO();
		
	}
}
