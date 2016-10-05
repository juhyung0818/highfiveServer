package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.HighfiveVO;
import org.highfive.service.HighfiveService;
import org.highfive.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserRegisterTest {
	
	@Inject
	private UserService userService;
	@Inject
	private HighfiveService hfService;

	@Test
	public void testRegister() throws Exception{
		HighfiveVO vo = new HighfiveVO();
		vo.setSender("jh");
		vo.setReceiver("kkk");
		
		if(hfService.getFlag(vo) == 0){
			userService.read("kkk", 0);
		}else {
			userService.read("kkk", 1);
		}
	}
}
