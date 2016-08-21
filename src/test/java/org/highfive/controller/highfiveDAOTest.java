package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.highfiveVO;
import org.highfive.persistence.highfiveDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class highfiveDAOTest {
	@Inject
	private highfiveDAO hdao;
	
//	@Test
//	public void testCreate(){
//		highfiveVO high=new highfiveVO();
//		high.setReceiver("RESEIVER");
//		high.setSender("SENDER");
//		high.setHiFlag(0);
//		high.setSenddate("2016-08-18");
//		hdao.create(high);
//	}
}
