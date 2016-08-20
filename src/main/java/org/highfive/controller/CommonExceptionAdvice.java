package org.highfive.controller;

import org.highfive.domain.ResultVO;
import org.highfive.exception.ExceptionCode;
import org.highfive.exception.HighfiveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class CommonExceptionAdvice {

  private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

  @ResponseBody
  @ExceptionHandler(HighfiveException.class)
  public ResultVO highfiveException(HighfiveException e) {

    logger.error(e.getMessage());
    
    ResultVO result = new ResultVO();
    result.setCode(e.getExceptionCode().getCode()); //100 중복 id
    result.setMessage(e.getExceptionCode().getMessage());
   
    return result;
  }
  
  @ResponseBody
  @ExceptionHandler(InvalidFormatException.class)
  public ResultVO invalidFormatException(InvalidFormatException e) {

    logger.error(e.getMessage(), e.getStackTrace());
    
    ResultVO result = new ResultVO();
    result.setCode(ExceptionCode.INVALID_TYPE.getCode()); //100 중복 id
    result.setMessage(ExceptionCode.INVALID_TYPE.getMessage());
 
    return result;
  }
  

  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ResultVO common(Exception e) {

    logger.error(e.getMessage());
    
    ResultVO result = new ResultVO();
    result.setCode(100); //100 중복 id
    result.setMessage("uid 겹쳐");
   
    return result;
  }
  


//  @ExceptionHandler(Exception.class)
//  private ModelAndView errorModelAndView(Exception ex) {
//
//    ModelAndView modelAndView = new ModelAndView();
//    modelAndView.setViewName("/error_common");
//    modelAndView.addObject("exception", ex);
//
//    return modelAndView;
//  }

}


