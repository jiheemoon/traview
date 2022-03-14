package com.traview.user;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "mapper.user.";
	
	public String selectTime() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "selectTime");
	}
	
}
