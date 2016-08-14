package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.TestVO;
import org.highfive.persistence.TestDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class TestDAOTest {

	@Inject
	private TestDAO dao;
	
	@Test
	public void testInsert() throws Exception{
		TestVO vo = new TestVO();
		vo.setTitle("title");
		vo.setContent("content");
		vo.setWriter("writer");
		dao.insertTest(vo);
	}
}
