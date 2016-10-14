package org.highfive.controller;

import org.highfive.domain.ResultVO;
import org.highfive.exception.InvalidTypeException;
import org.highfive.exception.NotAuthoriedException;
import org.highfive.exception.NotExistException;
import org.highfive.exception.PrimaryKeyDuplicatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	@ResponseBody
	@ExceptionHandler(PrimaryKeyDuplicatedException.class)
	public ResultVO highfiveException(PrimaryKeyDuplicatedException e) {

		logger.error(e.getMessage());
		ResultVO result = new ResultVO();
		result.setCode(e.getExceptionCode().getCode());
		result.setMessage(e.getExceptionCode().getMessage());
		return result;
	}

	@ResponseBody
	@ExceptionHandler(InvalidTypeException.class)
	public ResultVO invalidFormatException(InvalidTypeException e) {

		logger.error(e.getMessage(), e.getStackTrace());
		ResultVO result = new ResultVO();
		result.setCode(e.getExceptionCode().getCode());
		result.setMessage(e.getExceptionCode().getMessage());
		return result;

	}

	@ResponseBody
	@ExceptionHandler(NotExistException.class)
	public ResultVO notExistException(NotExistException e) {

		logger.error(e.getMessage());
		ResultVO result = new ResultVO<>();
		result.setCode(e.getExceptionCode().getCode());
		result.setMessage(e.getExceptionCode().getMessage());
		return result;
	}

	@ResponseBody
	@ExceptionHandler(NotAuthoriedException.class)
	public ResultVO notAuthoriedException(NotAuthoriedException e) {

		logger.error(e.getMessage());
		ResultVO result = new ResultVO<>();
		result.setCode(e.getExceptionCode().getCode());
		result.setMessage(e.getExceptionCode().getMessage());
		return result;
	}

	// @ResponseBody
	// @ExceptionHandler(Exception.class)
	// public ResultVO common(Exception e) {
	//
	// logger.error(e.getMessage());
	//
	// ResultVO result = new ResultVO();
	// result.setCode(100); //100 以묐났 id
	// result.setMessage("SQL Exception");
	//
	// return result;
	// }

	// @ExceptionHandler(Exception.class)
	// private ModelAndView errorModelAndView(Exception ex) {
	//
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.setViewName("/error_common");
	// modelAndView.addObject("exception", ex);
	//
	// return modelAndView;
	// }

}
