package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.ResultVO;
import org.highfive.service.FavoritesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Favorites/*")
public class FavoritesController {
	private static final Logger logger=LoggerFactory.getLogger(FavoritesController.class);
	
	@Inject
	private FavoritesService fservice;
	
	@ResponseBody
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ResultVO registPOST(@RequestBody FavoritesVO favorite){
		logger.info("regist post...........");
		logger.info(favorite.toString());
		
		fservice.regist(favorite);
		
		return new ResultVO();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ResultVO deletePOST(@RequestBody FavoritesVO favorite){
		logger.info("delete post...........");
		
		fservice.delete(favorite.getFno());
		
		return new ResultVO();
		
	}	

}
