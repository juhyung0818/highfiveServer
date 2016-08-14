package org.highfive.controller;

import javax.inject.Inject;

import org.highfive.domain.BoardVO;
import org.highfive.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("new title");
		vo.setContent("new content");
		vo.setWriter("jh");
		vo.setStartdate("2016-08-10");
		vo.setEnddate("2016-08-17");
		vo.setLanguage("jp");
		vo.setFlag(0);
		dao.create(vo);
	}
}
