package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.ResultVO;
import org.highfive.domain.HighfiveVO;
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
public class HighfiveController {
	private static final Logger logger=LoggerFactory.getLogger(HighfiveController.class);
	
	@Inject
	private highfiveService hservice;
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO registPOST(@RequestBody HighfiveVO high){
		logger.info("regist post...........");
		logger.info(high.toString());
		
		hservice.regist(high);
		

		return new ResultVO();
		
	}
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO deletePOST(@RequestBody HighfiveVO high){
		logger.info("delete post...........");
				
		hservice.delete(high.getHno());
				
		return new ResultVO();
		
	}
}
