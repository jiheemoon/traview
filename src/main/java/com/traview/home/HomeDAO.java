package com.traview.home;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.traview.home.";
	
	public String selectTime() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectTime");
	}
	
}
