package org.highfive.persistence;

import org.highfive.domain.TestVO;

public interface TestDAO {

	public void insertTest(TestVO vo);
	public TestVO read(int bno);
}
