package org.highfive.controller;

import org.highfive.domain.ResultVO;
import org.highfive.exception.ExceptionCode;
import org.highfive.exception.InvalidTypeException;
import org.highfive.exception.UserIdDuplicatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionAdvice {

  private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

  @ResponseBody
  @ExceptionHandler(UserIdDuplicatedException.class)
  public ResultVO highfiveException(UserIdDuplicatedException e) {

    logger.error(e.getMessage());
    
    ResultVO result = new ResultVO();
    result.setCode(e.getExceptionCode().getCode()); //100 중복 id
    result.setMessage(e.getExceptionCode().getMessage());
   
    return result;
  }
  
  @ResponseBody
  @ExceptionHandler(InvalidTypeException.class)
  public ResultVO invalidFormatException(InvalidTypeException e) {

    logger.error(e.getMessage(), e.getStackTrace());
    
    ResultVO result = new ResultVO();
    result.setCode(e.getExceptionCode().getCode()); //300 잘못된 타입
    result.setMessage(e.getExceptionCode().getMessage());
 
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


