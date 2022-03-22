package com.traview.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.traview.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "mapper.user.";
	
	public int insertUser(UserVO userVO) {
		return sqlSession.insert(NAMESPACE + "insertUser", userVO);
	}
	
}
