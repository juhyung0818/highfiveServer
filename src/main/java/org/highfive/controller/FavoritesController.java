package org.highfive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.highfive.domain.FavoritesVO;
import org.highfive.domain.ResultVO;
import org.highfive.domain.UserBoardVO;
import org.highfive.domain.UserVO;
import org.highfive.service.FavoritesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/favorites/*")
public class FavoritesController {
	private static final Logger logger=LoggerFactory.getLogger(FavoritesController.class);
	
	@Inject
	private FavoritesService fservice;
	
	
	@ResponseBody
	@RequestMapping(value="/like", method=RequestMethod.POST)
	public ResultVO like(@RequestBody FavoritesVO favorite) throws Exception{
		logger.info("favorites... " + favorite.toString());
		fservice.isLike(favorite);
		return new ResultVO();
	}

	//url : favorites/bookmark
	@ResponseBody
	@RequestMapping(value = "/bookmark", method=RequestMethod.POST)
	public ResultVO<List<UserBoardVO>> favoritesList(@RequestBody UserVO user) throws Exception{
		logger.info("favorites list.....");
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = fservice.favoritesList(user);
		return new ResultVO<>(list);
	}
	//@param "uid" : "~~"	@return list<UserBoardVO>
	//url : favorites/myboard
	@ResponseBody
	@RequestMapping(value = "/myboard", method=RequestMethod.POST)
	public ResultVO<List<UserBoardVO>> myBoardList(@RequestBody UserVO user) throws Exception{
		logger.info("My Board list.....");
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = fservice.myBoardList(user);
		return new ResultVO<>(list);
	}
	
	//@param "uid" : "~~"	@return list<UserBoardVO>
	//url : favorites/myreply
	@ResponseBody
	@RequestMapping(value = "/myreply", method=RequestMethod.POST)
	public ResultVO<List<UserBoardVO>> myReplyList(@RequestBody UserVO user) throws Exception{
		logger.info("My Reply list.....");
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		list = fservice.myReplyList(user);
		return new ResultVO<>(list);
	}
}
