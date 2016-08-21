package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.highfiveVO;
import org.highfive.service.highfiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/highfive/*")
public class highfiveController {
	private static final Logger logger=LoggerFactory.getLogger(highfiveController.class);
	
	@Inject
	private highfiveService hservice;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(highfiveVO hogh, Model hmodel){
		logger.info("register get........");
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPOST(highfiveVO high, Model hmodel){
		logger.info("regist post...........");
		logger.info(high.toString());
		
		hservice.regist(high);
		
		hmodel.addAttribute("result", "success");
		
		return "/success";
		
	}
}
