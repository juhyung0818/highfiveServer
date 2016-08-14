package org.highfive.controller;

import org.highfive.domain.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@RequestMapping("/doJSON")
	public @ResponseBody TestVO doJSON(){
		TestVO vo = new TestVO();
		vo.setBno(1);
		vo.setContent("content");
		vo.setTitle("title");
		vo.setWriter("writer");
		
		return vo;
	}
	

}
